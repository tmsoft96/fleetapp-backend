package com.tmsoft.fleetapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmsoft.fleetapp.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByUsername(String username);

	Boolean existsByUsername(String username);
}
