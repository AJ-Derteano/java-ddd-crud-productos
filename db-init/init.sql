-- Crear extensión para UUID, si no existe
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Tabla productos
CREATE TABLE IF NOT EXISTS producto (
    id UUID PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio NUMERIC(10, 2) NOT NULL,
    stock INTEGER NOT NULL,
    categoria VARCHAR(50),
    activo BOOLEAN NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    fecha_actualizacion TIMESTAMP NOT NULL
);

-- Tabla clientes
CREATE TABLE IF NOT EXISTS clientes (
    id UUID PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    dni VARCHAR(8) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    fecha_actualizacion TIMESTAMP NOT NULL
);
