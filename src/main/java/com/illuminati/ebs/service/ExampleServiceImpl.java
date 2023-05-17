package com.illuminati.ebs.service;

import com.illuminati.ebs.dto.ExampleDto;
import com.illuminati.ebs.entity.ExampleEntity;
import com.illuminati.ebs.mapper.ExampleMapper;
import com.illuminati.ebs.repository.ExampleRepository;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl extends GenericServiceImpl<ExampleDto, ExampleEntity, Long> implements ExampleService {

    public ExampleServiceImpl(ExampleRepository repository,ExampleMapper mapper) {
        super(repository, mapper);
    }
}
