package com.swcoaching.example1.user.jpa;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

  UserEntity findByUsername(String username);
}
