package com.example.clientesapi.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Cliente {
  private final UUID id;
  private final String nombres;
  private final String apellidos;
  private final String dni;
  private final String email;
  private final String telefono;
  private final LocalDateTime fechaCreacion;
  private final LocalDateTime fechaActualizacion;

  public Cliente actualizar(String nombres, String apellidos, String email, String telefono) {
    return Cliente.builder()
        .id(this.id)
        .nombres(nombres)
        .apellidos(apellidos)
        .dni(this.dni)
        .email(email)
        .telefono(telefono)
        .fechaCreacion(this.fechaCreacion)
        .fechaActualizacion(LocalDateTime.now())
        .build();
  }

}
