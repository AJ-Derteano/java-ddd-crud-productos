package com.example.clientesapi.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateClienteUseCase {
  private final ClienteService clienteService;

  public Cliente execute(UUID id, String nombres, String apellidos, String email, String telefono) {
    return clienteService.actualizarCliente(id, nombres, apellidos, email, telefono);
  }

}
