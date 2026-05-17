DROP DATABASE IF EXISTS bigData;
CREATE DATABASE bigData CHARACTER SET utf8mb4;
USE bigData;

CREATE TABLE empresas (
	id_empresa INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	sector VARCHAR(100) NOT NULL
);

CREATE TABLE registros_privacidad (
	id_registro INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	tipo_dato ENUM ("UBICACION", "ACTIVIDAD"),
	fecha_hora TIMESTAMP NOT NULL,
	detalle_dato VARCHAR(200) NOT NULL,
	nivel_sensibilidad ENUM("BAJO", "MEDIO", "ALTO"),
	id_empresa INT UNSIGNED NOT NULL,
	FOREIGN KEY (id_empresa) REFERENCES empresas (id_empresa)
);

 
INSERT INTO empresas (nombre, sector) VALUES
('Google', 'Servicios Digitales'), 
('Meta', 'Redes Sociales'),
('Amazon', 'E-commerce');
 

 