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
	tipo_dato ENUM ("Ubicacion", "Actividad"),
	fecha_hora TIMESTAMP NOT NULL,
	detalle_dato VARCHAR(200) NOT NULL,
	nivel_sensibilidad ENUM("Bajo", "Medio", "Alto"),
	id_empresa INT UNSIGNED NOT NULL,
	FOREIGN KEY (id_empresa) REFERENCES empresas (id_empresa)
);

 
INSERT INTO empresas (nombre, sector) VALUES ('Meta', 'Redes Sociales');

SELECT *
FROM empresas;

INSERT INTO registros_privacidad (tipo_dato, fecha_hora, detalle_dato, nivel_sensibilidad, id_empresa) VALUES 								('Actividad', NOW(), 'Like en publicación', 'Bajo', 1);
SELECT *
FROM registros_privacidad;