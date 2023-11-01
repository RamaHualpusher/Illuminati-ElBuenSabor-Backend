package com.illuminati.ebs.repository;

import com.illuminati.ebs.dto.ProductoRanking;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.exception.ServiceException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends GenericRepository<Producto, Long> {
    @Query("SELECT p.id, p.activo, p.denominacion, p.esBebida, p.imagen, p.nombre, p.precio, p.preparacion, p.stockActual, p.stockMinimo, p.tiempoEstimadoCocina, p.rubro, (SELECT SUM(dp.cantidad) FROM DetallePedido dp WHERE dp.producto = p AND dp.activo = true) AS totalVendido FROM Producto p WHERE p.activo = true ORDER BY totalVendido DESC")
    List<Object[]> findTopSellingProducts();
}




