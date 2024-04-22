package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoDto;
import com.illuminati.ebs.dto.ProductoRanking;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.entity.Producto_Ingrediente;
import com.illuminati.ebs.entity.Rubro;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.ProductoMapper;
import com.illuminati.ebs.repository.ProductoRepository;
import com.illuminati.ebs.repository.Producto_IngredienteRepository;
import com.illuminati.ebs.service.ProductoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements ProductoService {

    private final ProductoRepository repository;
    private final Producto_IngredienteRepository productoIngredienteRepository;

    public ProductoServiceImpl(ProductoRepository repository, Producto_IngredienteRepository productoIngredienteRepository) {
        super(repository);
        this.repository = repository;
        this.productoIngredienteRepository = productoIngredienteRepository; // Inyecta el repositorio de Producto_Ingrediente
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class) // Anotación para controlar la transacción
    public Producto save(Producto entity) throws ServiceException {
        try {
            // Guardar el producto
            entity = genericRepository.save(entity);
            entity.getRubro().setIngredientOwner(false);
            // Asignar el producto a cada Producto_Ingrediente y guardarlos
            for (Producto_Ingrediente pi : entity.getProductosIngredientes()) {
                pi.setActivo(true);
                pi.setProducto(entity);
                pi = productoIngredienteRepository.save(pi);
                //            // Forzar un error para probar el rollback
                //            if (pi.getId() == 1) {
                //                throw new ServiceException("Error forzado para probar el rollback");
                //            }
            }

            return entity;
        } catch (ServiceException e) {
            // Si ocurre una ServiceException, relanzarla para realizar el rollback
            throw e;
        } catch (Exception e) {
            // Si ocurre otra excepción, lanzar una ServiceException con código de estado INTERNAL_SERVER_ERROR
            throw new ServiceException("Error al guardar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public Producto update(Producto entity) throws ServiceException {
        try {
            // Verificar si el producto existe
            Producto existingProduct = findById(entity.getId());

            // Actualizar campos del producto
            existingProduct.setNombre(entity.getNombre());
            existingProduct.setTiempoEstimadoCocina(entity.getTiempoEstimadoCocina());
            existingProduct.setDenominacion(entity.getDenominacion());
            existingProduct.setImagen(entity.getImagen());
            existingProduct.setStockMinimo(entity.getStockMinimo());
            existingProduct.setStockActual(entity.getStockActual());
            existingProduct.setPreparacion(entity.getPreparacion());
            existingProduct.setPrecio(entity.getPrecio());
            existingProduct.setEsBebida(entity.getEsBebida());
            existingProduct.setRubro(entity.getRubro());

            // Identificar ingredientes eliminados o actualizados
            List<Producto_Ingrediente> newIngredientes = entity.getProductosIngredientes();
            List<Producto_Ingrediente> existingIngredientes = existingProduct.getProductosIngredientes();

            // Eliminar relaciones con ingredientes eliminados o actualizar cantidad en ingredientes existentes
            existingIngredientes.removeIf(existingIngrediente -> {
                Optional<Producto_Ingrediente> matchingIngrediente = newIngredientes.stream()
                        .filter(newIngrediente -> newIngrediente.getId().equals(existingIngrediente.getId()))
                        .findFirst();

                if (matchingIngrediente.isPresent()) {
                    // Actualizar la cantidad si ha cambiado
                    existingIngrediente.setCantidad(matchingIngrediente.get().getCantidad());
                    return false; // No eliminar el ingrediente
                } else {
                    // Eliminar el ingrediente que ya no está presente en la lista de nuevos ingredientes
                    productoIngredienteRepository.delete(existingIngrediente);
                    return true; // Eliminar el ingrediente
                }
            });

            // Agregar nuevos ingredientes y establecer la relación con el producto
            for (Producto_Ingrediente newIngrediente : newIngredientes) {
                if (!existingIngredientes.contains(newIngrediente)) {
                    newIngrediente.setProducto(existingProduct);
                    newIngrediente.setActivo(true);
                    productoIngredienteRepository.save(newIngrediente);
                }
            }

            // Guardar el producto actualizado
            return genericRepository.save(existingProduct);
        } catch (ServiceException e) {
            // Si ocurre una ServiceException, relanzarla para realizar el rollback
            throw e;
        } catch (Exception e) {
            // Si ocurre otra excepción, lanzar una ServiceException con código de estado INTERNAL_SERVER_ERROR
            throw new ServiceException("Error al actualizar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public List<ProductoRanking> findTopSellingProducts() throws ServiceException {
        try {
            return repository.findTopSellingProducts().stream()
                    .map(row -> new ProductoRanking((Long) row[0], (Boolean) row[1], (String) row[2], (Boolean) row[3], (String) row[4], (String) row[5], (Double) row[6], (String) row[7], (Integer) row[8], (Integer) row[9], (Integer) row[10], (Rubro) row[11], (Long) row[12]))
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            // Captura específicamente excepciones relacionadas con problemas de acceso a datos
            throw new ServiceException("Error al acceder a los datos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Captura todas las demás excepciones no esperadas
            throw new ServiceException("Error inesperado al obtener los productos más vendidos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    @Transactional
    public Producto addStock(Long productoId, Integer cantidad) throws ServiceException {
        if (cantidad <= 0) {
            throw new ServiceException("La cantidad debe ser un número positivo.", HttpStatus.BAD_REQUEST);
        }
        Producto producto = findById(productoId);
        producto.setStockActual(producto.getStockActual() + cantidad);
        return save(producto);
    }

    @Override
    @Transactional
    public Producto subtractStock(Long productoId, Integer cantidad) throws ServiceException {
        if (cantidad <= 0) {
            throw new ServiceException("La cantidad debe ser un número positivo.", HttpStatus.BAD_REQUEST);
        }
        Producto producto = findById(productoId);
        if(producto.getStockActual() < cantidad){
            throw new ServiceException("No hay suficiente stock para restar.", HttpStatus.BAD_REQUEST);
        }
        producto.setStockActual(producto.getStockActual() - cantidad);
        return save(producto);
    }
}