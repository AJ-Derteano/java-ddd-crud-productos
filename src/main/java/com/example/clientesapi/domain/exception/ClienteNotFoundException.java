package com.example.clientesapi.domain.exception;

import java.util.UUID;

public class ClienteNotFoundException extends BusinessException {

  public ClienteNotFoundException(UUID id) {
    super("No se encontró el cliente con ID: " + id);
  }

  public ClienteNotFoundException(String codigo) {
    super("No se encontró el cliente con código: " + codigo);
  }
}