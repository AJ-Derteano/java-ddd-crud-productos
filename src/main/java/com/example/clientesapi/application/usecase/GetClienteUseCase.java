package com.example.clientesapi.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetClienteUseCase {
  private final ClienteService clienteService;

  public Cliente executeById(UUID id) {
    return clienteService.obtenerClientePorId(id);
  }

  public Cliente executeByDni(String dni) {
    return clienteService.obtenerClientePorDni(dni);
  }

  public List<Cliente> executeAll() {
    return clienteService.obtenerTodosLosClientes();
  }
}
