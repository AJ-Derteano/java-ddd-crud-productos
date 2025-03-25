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
public class ClienteUpdateResquest {

  @NotBlank(message = "El nombre es obligatorio")
  @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
  private String nombres;

  @NotBlank(message = "El apellido es obligatorio")
  @Size(min = 3, max = 100, message = "El apellido debe tener entre 3 y 100 caracteres")
  private String apellidos;

  @NotBlank(message = "El email es obligatorio")
  @Size(min = 3, max = 100, message = "El email debe tener entre 3 y 100 caracteres")
  private String email;

  @NotBlank(message = "El teléfono es obligatorio")
  @Size(min = 9, max = 9, message = "El teléfono debe tener 9 caracteres")
  private String telefono;

}
