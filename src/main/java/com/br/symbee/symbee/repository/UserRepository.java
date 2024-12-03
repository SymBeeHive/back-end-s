package com.br.symbee.symbee.repository;

import com.br.symbee.symbee.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Override
    List<UserEntity> findAll();
}