package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.PedidoDto;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.repository.PedidoRepository;
import com.illuminati.ebs.service.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoService {

    private final PedidoRepository repository;
    public PedidoServiceImpl(PedidoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Pedido> findPedidosByUsuarioId(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
    @Override
    public Optional<PedidoDto> getPedidoCompletoById(Long pedidoId) {
        return repository.findPedidoWithDetallesAndProductosById(pedidoId);
    }
    @Override
    @Transactional
    public Pedido findById(Long id) throws ServiceException {
        Optional<Pedido> entity = repository.findById(id);
        if(entity.isPresent()) {
            Pedido pedido = entity.get();
            //Aca validamos lo que queramos
        }
        try {
            return genericRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró ninguna entidad con el ID: " + id));
        } catch (EntityNotFoundException e) {
            throw new ServiceException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
