package com.example.clientesapi.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.clientesapi.domain.model.Cliente;

public interface ClienteRepository {

  Cliente save(Cliente cliente);

  Optional<Cliente> findById(UUID id);

  Optional<Cliente> findByDni(String dni);

  List<Cliente> findAll();

  List<Cliente> findByNombres(String nombres);

  void deleteById(UUID id);

  boolean existsByDni(String dni);

}
