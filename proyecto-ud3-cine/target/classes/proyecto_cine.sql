-- Crear usuario
-- CREATE USER 'godoy'@'localhost' IDENTIFIED BY '4321';
-- Dar privilegios específicos
GRANT ALL PRIVILEGES ON cinebasedatos.* TO 'godoy'@'localhost';
-- Verificar los privilegios
SHOW GRANTS FOR 'godoy'@'localhost';
-- Eliminar base de datos existente
DROP DATABASE IF EXISTS cinebasedatos;
-- Crear base de datos
CREATE DATABASE cinebasedatos;
-- Usar base de datos
USE cinebasedatos;