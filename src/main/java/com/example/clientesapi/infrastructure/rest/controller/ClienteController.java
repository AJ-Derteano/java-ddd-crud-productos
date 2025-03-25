package com.example.clientesapi.infrastructure.rest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientesapi.application.usecase.CreateClienteUseCase;
import com.example.clientesapi.application.usecase.DeleteClienteUseCase;
import com.example.clientesapi.application.usecase.GetClienteUseCase;
import com.example.clientesapi.application.usecase.UpdateClienteUseCase;
import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.infrastructure.persistence.mapper.ClienteMapper;
import com.example.clientesapi.infrastructure.rest.dto.ClienteRequest;
import com.example.clientesapi.infrastructure.rest.dto.ClienteResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

  private final CreateClienteUseCase createClienteUseCase;
  private final GetClienteUseCase getClienteUseCase;
  private final UpdateClienteUseCase updateClienteUseCase;
  private final DeleteClienteUseCase deleteClienteUseCase;
  private final ClienteMapper mapper;

  @PostMapping
  public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest request) {
    Cliente cliente = mapper.toDomain(request);
    Cliente creado = createClienteUseCase.execute(cliente);
    return ResponseEntity.ok(mapper.toResponse(creado));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClienteResponse> obtenerCliente(@PathVariable UUID id) {
    Cliente cliente = getClienteUseCase.executeById(id);
    return ResponseEntity.ok(mapper.toResponse(cliente));
  }

  @GetMapping("/dni/{dni}")
  public ResponseEntity<ClienteResponse> obtenerClientePorDni(@PathVariable String dni) {
    Cliente cliente = getClienteUseCase.executeByDni(dni);
    return ResponseEntity.ok(mapper.toResponse(cliente));
  }

  @GetMapping
  public ResponseEntity<List<ClienteResponse>> obtenerClientes() {
    List<Cliente> clientes = getClienteUseCase.executeAll();
    return ResponseEntity.ok(mapper.toResponseList(clientes));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ClienteResponse> actualizarCliente(@PathVariable UUID id, @RequestBody ClienteRequest request) {
    Cliente actualizado = updateClienteUseCase.execute(id, request.getNombres(), request.getApellidos(),
        request.getEmail(), request.getTelefono());

    return ResponseEntity.ok(mapper.toResponse(actualizado));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarCliente(@PathVariable UUID id) {
    deleteClienteUseCase.execute(id);
    return ResponseEntity.noContent().build();
  }

}
