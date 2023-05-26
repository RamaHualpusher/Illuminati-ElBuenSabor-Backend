package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.UserAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends GenericRepository<UserAuth, Long> {
}
