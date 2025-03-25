package com.example.clientesapi.infrastructure.persistence.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.infrastructure.persistence.entity.ClienteEntity;
import com.example.clientesapi.infrastructure.rest.dto.ClienteRequest;
import com.example.clientesapi.infrastructure.rest.dto.ClienteResponse;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

  ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

  Cliente toDomain(ClienteEntity entity);

  ClienteEntity toEntity(Cliente domain);

  @Mapping(target = "id", expression = "java(generarId())")
  @Mapping(target = "fechaCreacion", expression = "java(obtenerFechaActual())")
  @Mapping(target = "fechaActualizacion", expression = "java(obtenerFechaActual())")
  Cliente toDomain(ClienteRequest request);

  ClienteResponse toResponse(Cliente domain);

  List<ClienteResponse> toResponseList(List<Cliente> domainList);

  @Named("generarId")
  default UUID generarId() {
    return UUID.randomUUID();
  }

  @Named("obtenerFechaActual")
  default LocalDateTime obtenerFechaActual() {
    return LocalDateTime.now();
  }

}
