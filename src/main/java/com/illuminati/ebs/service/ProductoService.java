package com.illuminati.ebs.service;

import com.illuminati.ebs.dto.ProductoRanking;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.exception.ServiceException;

import java.util.List;

public interface ProductoService extends GenericService<Producto, Long> {
    List<ProductoRanking> findTopSellingProducts() throws ServiceException;
}
