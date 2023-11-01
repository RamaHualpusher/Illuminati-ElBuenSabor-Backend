package com.illuminati.ebs.service;

import com.illuminati.ebs.dto.ProductoRanking;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.exception.ServiceException;

import java.util.List;

public interface ProductoService extends GenericService<Producto, Long> {
    List<ProductoRanking> findTopSellingProducts() throws ServiceException;
    public Producto addStock(Long productoId, Integer cantidad) throws ServiceException;
    public Producto subtractStock(Long productoId, Integer cantidad) throws ServiceException;
}
