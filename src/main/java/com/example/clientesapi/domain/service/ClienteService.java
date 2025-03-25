package com.example.clientesapi.domain.service;

import java.util.List;
import java.util.UUID;

import com.example.clientesapi.domain.model.Cliente;

public interface ClienteService {
  Cliente crearCliente(Cliente cliente);

  Cliente obtenerClientePorId(UUID id);

  Cliente obtenerClientePorDni(String dni);

  List<Cliente> obtenerTodosLosClientes();

  Cliente actualizarCliente(UUID id, String nombres, String apellidos, String email, String telefono);

  void eliminarCliente(UUID id);

}
