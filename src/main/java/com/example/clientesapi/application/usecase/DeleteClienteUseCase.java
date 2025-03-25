package com.example.clientesapi.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.clientesapi.domain.service.ClienteService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteClienteUseCase {
  private final ClienteService clienteService;

  public void execute(UUID id) {
    clienteService.eliminarCliente(id);
  }
}
