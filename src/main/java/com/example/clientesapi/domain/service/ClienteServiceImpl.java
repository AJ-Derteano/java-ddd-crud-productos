package com.example.clientesapi.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clientesapi.domain.exception.BusinessException;
import com.example.clientesapi.domain.exception.ClienteNotFoundException;
import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

  private final ClienteRepository clienteRepository;

  @Override
  public Cliente crearCliente(Cliente cliente) {

    if (clienteRepository.existsByDni(cliente.getDni())) {
      throw new BusinessException("Ya existe un cliente con el DNI: " + cliente.getDni());
    }

    return clienteRepository.save(cliente);
  }

  @Override
  @Transactional(readOnly = true)
  public Cliente obtenerClientePorId(UUID id) {
    return clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
  }

  @Override
  @Transactional(readOnly = true)
  public Cliente obtenerClientePorDni(String dni) {
    return clienteRepository.findByDni(dni).orElseThrow(() -> new ClienteNotFoundException(dni));
  }

  @Override
  @Transactional(readOnly = true)
  public List<Cliente> obtenerTodosLosClientes() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente actualizarCliente(UUID id, String nombres, String apellidos, String email, String telefono) {
    Cliente cliente = obtenerClientePorId(id);

    Cliente clienteUpdate = cliente.actualizar(nombres, apellidos, email, telefono);

    return clienteRepository.save(clienteUpdate);

  }

  @Override
  public void eliminarCliente(UUID id) {

    if (!clienteRepository.findById(id).isPresent()) {
      throw new ClienteNotFoundException(id);

    }

    clienteRepository.deleteById(id);
  }

}
