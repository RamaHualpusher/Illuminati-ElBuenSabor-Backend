package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.ExampleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends GenericRepository<ExampleEntity, Long> {
}
