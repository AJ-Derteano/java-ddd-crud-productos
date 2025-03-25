package com.example.clientesapi.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

  private UUID id;
  private String nombres;
  private String apellidos;
  private String dni;
  private String email;
  private String telefono;
  private LocalDateTime fechaCreacion;
  private LocalDateTime fechaActualizacion;

}
