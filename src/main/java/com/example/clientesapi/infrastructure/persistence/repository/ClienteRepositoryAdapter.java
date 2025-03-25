package com.example.clientesapi.infrastructure.persistence.repository;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.repository.ClienteRepository;
import com.example.clientesapi.infrastructure.persistence.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepository {

  private final ClienteJpaRepository jpaRepository;
  private final ClienteMapper mapper;

  @Override
  public Cliente save(Cliente cliente) {
    var entity = mapper.toEntity(cliente);
    var savedEntity = jpaRepository.save(entity);
    return mapper.toDomain(savedEntity);
  }

  @Override
  public Optional<Cliente> findById(UUID id) {
    return jpaRepository.findById(id)
        .map(mapper::toDomain);
  }

  @Override
  public Optional<Cliente> findByDni(String dni) {
    return jpaRepository.findByDni(dni)
        .map(mapper::toDomain);
  }

  @Override
  public List<Cliente> findAll() {
    return jpaRepository.findAll().stream()
        .map(mapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public List<Cliente> findByNombres(String nombres) {
    return jpaRepository.findByNombres(nombres).stream()
        .map(mapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public boolean existsByDni(String dni) {
    return jpaRepository.existsByDni(dni);
  }

  @Override
  public void deleteById(UUID id) {
    jpaRepository.deleteById(id);
  }

}
