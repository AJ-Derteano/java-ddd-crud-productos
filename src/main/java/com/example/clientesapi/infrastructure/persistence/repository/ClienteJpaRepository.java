package com.example.clientesapi.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clientesapi.infrastructure.persistence.entity.ClienteEntity;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {

  Optional<ClienteEntity> findByDni(String dni);

  List<ClienteEntity> findByNombres(String nombres);

  boolean existsByDni(String dni);
}
