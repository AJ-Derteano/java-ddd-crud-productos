package com.example.clientesapi.application.usecase;

import org.springframework.stereotype.Component;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateClienteUseCase {

  private final ClienteService clienteService;

  public Cliente execute(Cliente cliente) {
    return clienteService.crearCliente(cliente);
  }

}
