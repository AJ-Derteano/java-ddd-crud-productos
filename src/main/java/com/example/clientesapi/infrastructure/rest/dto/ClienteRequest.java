package com.example.clientesapi.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

  @NotBlank(message = "El nombre es obligatorio")
  @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
  private String nombres;

  @NotBlank(message = "El apellido es obligatorio")
  @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
  private String apellidos;

  @NotBlank(message = "El DNI es obligatorio")
  @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
  private String dni;

  @NotBlank(message = "El email es obligatorio")
  @Size(min = 3, max = 50, message = "El email debe tener entre 3 y 50 caracteres")
  private String email;

  @NotBlank(message = "El teléfono es obligatorio")
  @Size(min = 9, max = 9, message = "El teléfono debe tener 9 caracteres")
  private String telefono;
}
