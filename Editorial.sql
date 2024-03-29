
-- MySQL Script generated by MySQL Workbench
-- Tue Jan 17 00:14:36 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Editorial
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Editorial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Editorial` DEFAULT CHARACTER SET utf8 ;
USE `Editorial` ;

-- -----------------------------------------------------
-- Table `Editorial`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Autor` (
  `cedula_Autor` VARCHAR(10) NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(10) NULL,
  `Direccion` VARCHAR(100) NOT NULL,
  `Correo` VARCHAR(128) NULL,
  `Especialidad` VARCHAR(30) NULL,
  `Salario` DECIMAL NOT NULL DEFAULT 450.00,
  PRIMARY KEY (`cedula_Autor`));


-- -----------------------------------------------------
-- Table `Editorial`.`Articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Articulo` (
  `idArticulo` INT NOT NULL AUTO_INCREMENT,
  `Descripción` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idArticulo`));


-- -----------------------------------------------------
-- Table `Editorial`.`RevistaInicial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`RevistaInicial` (
  `idRevistaInicial` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRevistaInicial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Editor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Editor` (
  `cedula_Ed` VARCHAR(10) NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(10) NULL,
  `Direccion` VARCHAR(100) NOT NULL,
  `Correo` VARCHAR(128) NULL,
  `Salario` DECIMAL NOT NULL DEFAULT 450.00,
  PRIMARY KEY (`cedula_Ed`));


-- -----------------------------------------------------
-- Table `Editorial`.`Aprobacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Aprobacion` (
  `idArticulo` INT NOT NULL,
  `idRevistaInicial` INT NOT NULL,
  `cedula_Ed` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idArticulo`, `idRevistaInicial`, `cedula_Ed`),
  INDEX `fk_Aprobación_Articulo1_idx` (`idArticulo` ASC) VISIBLE,
  INDEX `fk_Aprobación_Revista1_idx` (`idRevistaInicial` ASC) VISIBLE,
  INDEX `fk_Aprobacion_Editor1_idx` (`cedula_Ed` ASC) VISIBLE,
  CONSTRAINT `fk_Aprobación_Articulo1`
    FOREIGN KEY (`idArticulo`)
    REFERENCES `Editorial`.`Articulo` (`idArticulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aprobación_Revista1`
    FOREIGN KEY (`idRevistaInicial`)
    REFERENCES `Editorial`.`RevistaInicial` (`idRevistaInicial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aprobacion_Editor1`
    FOREIGN KEY (`cedula_Ed`)
    REFERENCES `Editorial`.`Editor` (`cedula_Ed`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`HistorialArticulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`HistorialArticulo` (
  `idArticulo` INT NOT NULL,
  `Comentario` VARCHAR(200) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  `cedula_Ed` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idArticulo`, `cedula_Ed`),
  INDEX `fk_HistorialArticulo_Articulo1_idx` (`idArticulo` ASC) VISIBLE,
  INDEX `fk_HistorialArticulo_Editor1_idx` (`cedula_Ed` ASC) VISIBLE,
  CONSTRAINT `fk_HistorialArticulo_Articulo1`
    FOREIGN KEY (`idArticulo`)
    REFERENCES `Editorial`.`Articulo` (`idArticulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HistorialArticulo_Editor1`
    FOREIGN KEY (`cedula_Ed`)
    REFERENCES `Editorial`.`Editor` (`cedula_Ed`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Escribe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Escribe` (
  `cedula_Autor` VARCHAR(10) NOT NULL,
  `idArticulo` INT NOT NULL,
  PRIMARY KEY (`cedula_Autor`, `idArticulo`),
  INDEX `fk_Escribe_Articulo1_idx` (`idArticulo` ASC) VISIBLE,
  CONSTRAINT `fk_Escribe_Autor1`
    FOREIGN KEY (`cedula_Autor`)
    REFERENCES `Editorial`.`Autor` (`cedula_Autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Escribe_Articulo1`
    FOREIGN KEY (`idArticulo`)
    REFERENCES `Editorial`.`Articulo` (`idArticulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Maquetacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Maquetacion` (
  `idRevistaInicial` INT NOT NULL,
  `fecha_Inicio` DATE NOT NULL,
  `fecha_Fin` DATE NOT NULL,
  `Comentario` VARCHAR(250) NULL,
  PRIMARY KEY (`idRevistaInicial`),
  INDEX `fk_Maquetación_Revista1_idx` (`idRevistaInicial` ASC) VISIBLE,
  CONSTRAINT `fk_Maquetación_Revista1`
    FOREIGN KEY (`idRevistaInicial`)
    REFERENCES `Editorial`.`RevistaInicial` (`idRevistaInicial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Diseñador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Diseñador` (
  `cedula_Dis` VARCHAR(10) NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(10) NULL,
  `Direccion` VARCHAR(100) NOT NULL,
  `Correo` VARCHAR(128) NULL,
  `Salario` DECIMAL NOT NULL DEFAULT 450.00,
  PRIMARY KEY (`cedula_Dis`));


-- -----------------------------------------------------
-- Table `Editorial`.`Diseña`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Diseña` (
  `idRevistaInicial` INT NOT NULL,
  `cedula_Dis` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idRevistaInicial`, `cedula_Dis`),
  INDEX `fk_Diseña_Diseñador1_idx` (`cedula_Dis` ASC) VISIBLE,
  INDEX `fk_Diseña_Maquetacion1_idx` (`idRevistaInicial` ASC) VISIBLE,
  CONSTRAINT `fk_Diseña_Diseñador1`
    FOREIGN KEY (`cedula_Dis`)
    REFERENCES `Editorial`.`Diseñador` (`cedula_Dis`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Diseña_Maquetacion1`
    FOREIGN KEY (`idRevistaInicial`)
    REFERENCES `Editorial`.`Maquetacion` (`idRevistaInicial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Seccion` (
  `idSeccion` INT NOT NULL AUTO_INCREMENT,
  `Seccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSeccion`),
  UNIQUE INDEX `Seccion_UNIQUE` (`Seccion` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Publicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Publicacion` (
  `idRevistaInicial` INT NOT NULL,
  `idSeccion` INT NOT NULL,
  `fechaPublicacion` DATE NOT NULL,
  `Precio` DECIMAL NOT NULL DEFAULT 30.00,
  PRIMARY KEY (`idRevistaInicial`, `idSeccion`),
  INDEX `fk_Publicacion_Seccion1_idx` (`idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_Publicacion_Maquetacion1`
    FOREIGN KEY (`idRevistaInicial`)
    REFERENCES `Editorial`.`Maquetacion` (`idRevistaInicial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publicacion_Seccion1`
    FOREIGN KEY (`idSeccion`)
    REFERENCES `Editorial`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO Autor(cedula_Autor, Nombre, Apellido, Telefono, Direccion, Correo, Especialidad) VALUES 
('0987629425', 'Michael', 'Estrabao', '3374832949', 'Acasias', null, 'Biología'),
('0912345098', 'Carlos', 'Tingo', '8475629403', 'Florida', 'tingocarl@espol.edu.ec', 'Química'),
('0927467832', 'Michelle', 'Santana', '2840593849', 'Carchi y Tungurahua', 'micasan@espol.edu.ec', 'Física'),
('0982345767', 'Clara', 'Vera', '2849503758', 'Carchi y Velez', null, 'Computación');

insert into Articulo(Descripción) VALUES
('Investigación acerca de las computadoras cuánticas'), #compu-fis -1-1
('Investigación acerca del arte por medio de A.I.'), #compu -2-1
('Investigación acerca de la vida marina en las islas Malvinas'), #biol -3-2
('Investigación acerca del calentamiento global en la actualidad'), #biol -4-2
('Investigación acerca de los agujeros negros'), #fis -5-3
('Visita a las instalaciones de la Organización Europea para la Investigación Nuclear "CERN"'), #fis -6-3
('Potenciador de la quimioterapia para pacientes de cáncer'), #quim -7-4
('Función de los enlaces químicos en sólidos para desarrollos en nanotecnología'), #quim -8-4
('Investigacion acerca de los microplásticos'); #quim -9

insert into Escribe values
('0987629425', 3),
('0987629425', 4),
('0912345098', 7),
('0912345098', 8),
('0927467832', 1),
('0927467832', 5),
('0982345767', 1),
('0982345767', 2),
('0912345098', 9);

insert into editor(cedula_Ed, Nombre, Apellido, Telefono, Direccion, Correo ) values
('0957483647', 'Raul', 'Salinas', '3049586737', 'Carchi y Tungurahua','dmurphy@espol.edu.ec'),
('0912983746', 'Ana', 'Santos', '4758392748', 'Carchi y Tungurahua','jfirrelli@espol.edu.ec'),
('0927364518', 'Steven', 'Universe', '4758354625', 'Los Ríos y Clemente Ballen',null);

insert into historialarticulo values
(1, 'Listo para adjuntar en su respectiva revista', 'True', '0957483647'),
(2, 'Listo para adjuntar en su respectiva revista', 'True', '0957483647'),
(3, 'Listo para adjuntar en su respectiva revista', 'True', '0957483647'),
(4, 'Listo para adjuntar en su respectiva revista', 'True', '0912983746'),
(5, 'Listo para adjuntar en su respectiva revista', 'True', '0912983746'),
(6, 'Listo para adjuntar en su respectiva revista', 'True', '0912983746'),
(7, 'Listo para adjuntar en su respectiva revista', 'True', '0927364518'),
(8, 'Listo para adjuntar en su respectiva revista', 'True', '0927364518'),
(9, 'Falta más detalles, falta de referencias confiables', 'False', '0927364518');

insert into diseñador(cedula_Dis, Nombre, Apellido, Telefono, Direccion, Correo) values
('0947587653', 'Clara', 'Escobar', '2029837489', 'Carchi y Tungurahua','ljennings@espol.edu.ec'),
('0934526736', 'Luis', 'Herrera', '2345098764', 'Carchi y Tungurahua',null),
('0987652345', 'Miguel', 'Estrada', '1029475947', 'Los Ríos y Clemente Ballen',null);

insert into revistainicial(Titulo) values
('Avances en el área de la informática'),
('La vida en el planeta Tierra actualmente'),
('CERN'),
('Avances en el área de la química');

insert into aprobacion values
(1, 1, '0957483647'),
(2, 1, '0957483647'),
(3, 2, '0957483647'),
(4, 2, '0912983746'),
(5, 3, '0912983746'),
(6, 3, '0912983746'),
(7, 4, '0927364518'),
(8, 4, '0927364518');

insert into diseña values
(1,'0947587653'),
(2,'0934526736'),
(3,'0987652345'),
(4,'0947587653'),
(1,'0934526736'),
(2,'0987652345'),
(3,'0947587653'),
(4,'0934526736');

insert into maquetacion(fecha_Inicio, fecha_Fin, idRevistaInicial) values
('2022-04-01', '2022-05-01', 1),#1
('2022-04-01', '2022-05-01', 2),#2
('2022-04-01', '2022-05-01', 3),#3
('2022-04-01', '2022-05-01', 4);#4

insert into seccion(Seccion) values
('Ciencia y Tecnología'),
('Divulgación Científica');

insert into publicacion(idRevistaInicial, idSeccion, fechaPublicacion) values
(1,2,'2022-06-01'),
(2,2,'2022-06-02'),
(3,1,'2022-06-03'),
(4,2,'2022-06-04');


DELIMITER //
CREATE PROCEDURE ObtenerEstadoArticulo(
	IN idIngresado INT, 
	OUT estado VARCHAR(255), 
	out articulo VARCHAR(255))
BEGIN
	declare state VARCHAR(255);
    declare art VARCHAR(255);
  -- Ejecutar la consulta y almacenar el resultado
  SELECT h.Estado FROM HistorialArticulo h WHERE h.idArticulo = idIngresado INTO @state;
  SELECT a.Descripción FROM HistorialArticulo h natural join Articulo a WHERE h.idArticulo = idIngresado INTO @art;

  if idIngresado is null then
	SET estado = 'Todos los campos son obligatorios';
  else
	  -- Verificar si la consulta devolvió algún resultado
	  IF @state IS NULL THEN
		-- Asignar un mensaje al parámetro de salida si el valor no existe en la tabla
		SET estado = 'El valor proporcionado para idArticulo no se encuentra en la tabla HistorialArticulo';
		set articulo=null;
	  ELSE
		-- Asignar el Estado al parámetro de salida si se encontró un resultado
		SET estado = @state;
		SET articulo= @art;
	  END IF;
	end if;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE CrearSeccion(IN nueva_seccion VARCHAR(45), out mensaje varchar(50))
BEGIN
  declare exito int;
  declare seccionExiste int;
  START TRANSACTION;
  set exito=0;
  -- Verificar si la sección ya existe
  SELECT COUNT(*) FROM Seccion WHERE Seccion = nueva_seccion INTO @seccionExiste;
  
  -- Si la sección no existe, insertar una nueva fila en la tabla
  if nueva_seccion is null then
	rollback;
	SET mensaje = "Todos los campos son obligatorios";
    
  else
	  IF @seccionExiste = 0 THEN
		INSERT INTO Seccion (Seccion) VALUES (nueva_seccion);
		set exito = 1;
	  END IF;
	  if exito = 1 then
		set mensaje='Proceso ejecutado correctamente';
		commit;
	  else 
		set mensaje= 'La sección ya está creada';
		rollback;
	  end if;
	end if;
    select *
	from Seccion;
END //
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE InsertarAutor(
IN cedAutor VARCHAR(10),
IN nomAutor VARCHAR(30),
IN apellAutor VARCHAR(45),
IN tlfAutor VARCHAR(10),
IN direcAutor VARCHAR(100),
IN correoAutor VARCHAR(128),
IN espAutor VARCHAR(30),
IN salarioAutor FLOAT,
out mensaje varchar(50))
BEGIN
	declare exito int;
	declare count int;
	START TRANSACTION;
    IF cedAutor IS NULL OR nomAutor IS NULL OR apellAutor IS NULL OR tlfAutor IS NULL OR 
    direcAutor IS NULL OR correoAutor IS NULL OR espAutor IS NULL OR salarioAutor IS NULL THEN
		SET mensaje = "Todos los campos son obligatorios";
        rollback;
        
	ELSE 
			-- Verificar si ya existe un autor con la misma cédula
			SELECT COUNT(*) INTO @count FROM Autor WHERE cedula_Autor = cedAutor;
			-- Insertar el nuevo autor si no existe otro con la misma cédula
			IF (@count = 0) THEN
				INSERT INTO Autor (cedula_Autor, Nombre, Apellido, Telefono, Direccion, Correo, Especialidad, Salario)
				VALUES (cedAutor, nomAutor, apellAutor, tlfAutor, direcAutor, correoAutor, espAutor, salarioAutor);
				
				set mensaje='Proceso ejecutado correctamente';
                commit;
			ELSE
				set mensaje = 'El autor ya está registrado';
                rollback;
			END IF;
			END IF;
	select *
	from Autor;
END $$
DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
