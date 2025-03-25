package com.example.clientesapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clientes2")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ClienteEntity {

  @Id
  private UUID id;

  @Column(nullable = false, length = 50)
  private String nombres;

  @Column(nullable = false, length = 50)
  private String apellidos;

  @Column(nullable = false, length = 8)
  private String dni;

  @Column(nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 15)
  private String telefono;

  @CreatedDate
  @Column(name = "fecha_creacion", nullable = false, updatable = false)
  private LocalDateTime fechaCreacion;

  @LastModifiedDate
  @Column(name = "fecha_actualizacion", nullable = false)
  private LocalDateTime fechaActualizacion;
}
