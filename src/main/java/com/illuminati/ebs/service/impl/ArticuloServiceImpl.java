package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ArticuloDto;
import com.illuminati.ebs.entity.Articulo;
import com.illuminati.ebs.entity.Rubro;
import com.illuminati.ebs.entity.UnidadMedida;
import com.illuminati.ebs.exception.ResourceNotFoundException;
import com.illuminati.ebs.mapper.ArticuloMapper;
import com.illuminati.ebs.repository.ArticuloRepository;
import com.illuminati.ebs.repository.RubroRepository;
import com.illuminati.ebs.repository.UnidadMedidaRepository;
import com.illuminati.ebs.service.ArticuloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.illuminati.ebs.mapper.GenericMapper.modelMapper;

@Service
public class ArticuloServiceImpl extends GenericServiceImpl<ArticuloDto, Articulo, Long> implements ArticuloService {

    @Autowired
    RubroRepository rubroRepository;
    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;

    private ArticuloMapper articuloMapper; // Agrega una referencia a ArticuloMapper

    public ArticuloServiceImpl(ArticuloRepository repository, ArticuloMapper mapper) {
        super(repository, mapper);
        this.articuloMapper = mapper;
    }

    @Override
    public ArticuloDto save(ArticuloDto articuloDto) throws ResourceNotFoundException {
        Articulo articulo = articuloMapper.toEntity(articuloDto); // Utiliza el mapper definido

        // busca el rubro en la base de datos
        Rubro rubro = rubroRepository.findById(articuloDto.getRubroId())
                .orElseThrow(() -> new ResourceNotFoundException("Rubro no encontrado"));

        // establece el rubro en el articulo
        articulo.setRubro(rubro);

        // el resto de tu código para guardar el articulo...

        UnidadMedida unidadMedida = unidadMedidaRepository.findById(articuloDto.getUnidadMedidaId())
                .orElseThrow(() -> new ResourceNotFoundException("Unidad de medida no encontrada"));

        articulo.setUnidadMedida(unidadMedida);

        // guarda el articulo en la base de datos
        Articulo savedArticulo = repository.save(articulo);

        // convierte el articulo guardado a un ArticuloDto y lo retorna
        return articuloMapper.toDto(savedArticulo); // Utiliza el mapper definido
    }

    @Override
    public ArticuloDto update(Long id, ArticuloDto articuloDto) throws ResourceNotFoundException {
        Articulo articulo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Articulo no encontrado"));
        articulo.setDenominacion(articuloDto.getDenominacion());
        articulo.setPrecioCompra(articuloDto.getPrecioCompra());
        articulo.setPrecioVenta(articuloDto.getPrecioVenta());
        articulo.setStockMinimo(articuloDto.getStockMinimo());
        articulo.setStockActual(articuloDto.getStockActual());
        articulo.setEsBebida(articuloDto.getEsBebida());
        Rubro rubro = rubroRepository.findById(articuloDto.getRubroId())
                .orElseThrow(() -> new ResourceNotFoundException("Rubro no encontrado"));
        articulo.setRubro(rubro);
        UnidadMedida unidadMedida = unidadMedidaRepository.findById(articuloDto.getUnidadMedidaId())
                .orElseThrow(() -> new ResourceNotFoundException("Unidad de medida no encontrada"));
        articulo.setUnidadMedida(unidadMedida);
        Articulo updatedArticulo = repository.save(articulo);
        return articuloMapper.toDto(updatedArticulo);
    }

    @Override
    public boolean delete(Long id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Articulo no encontrado");
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<ArticuloDto> findAll() throws Exception {
        List<Articulo> articulos = repository.findAll();
        return articuloMapper.toDtoList(articulos);
    }

    @Override
    public ArticuloDto findById(Long id) throws ResourceNotFoundException {
        Articulo articulo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Articulo no encontrado"));
        return articuloMapper.toDto(articulo);
    }




}
