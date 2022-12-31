drop database if exists editorial;
-- MySQL Script generated by MySQL Workbench
-- Fri Dec 30 23:35:16 2022
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
  `Dirección` VARCHAR(100) NOT NULL,
  `Correo` VARCHAR(128) NULL,
  `fecha_Nacimiento` DATE NOT NULL,
  `Especialidad` VARCHAR(30) NULL,
  PRIMARY KEY (`cedula_Autor`));


-- -----------------------------------------------------
-- Table `Editorial`.`Articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Articulo` (
  `idArticulo` INT NOT NULL AUTO_INCREMENT,
  `Descripción` VARCHAR(100) NULL,
  PRIMARY KEY (`idArticulo`));


-- -----------------------------------------------------
-- Table `Editorial`.`Editor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Editor` (
  `cedula_Editor` VARCHAR(10) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Dirección` VARCHAR(45) NOT NULL,
  `fecha_Nacimiento` DATE NOT NULL,
  `Salario` DECIMAL NOT NULL DEFAULT 450.00,
  `Correo` VARCHAR(128) NULL,
  `tipoCargo` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(10) NULL,
  PRIMARY KEY (`cedula_Editor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`RevistaInicial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`RevistaInicial` (
  `idRevistaInicial` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRevistaInicial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Aprobacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Aprobacion` (
  `idAprobacion` INT NOT NULL AUTO_INCREMENT,
  `cedula_Editor` VARCHAR(10) NOT NULL,
  `idArticulo` INT NOT NULL,
  `SecciónPublicar` VARCHAR(45) NOT NULL,
  `Estado` TINYINT NULL,
  `Aprobacióncol` VARCHAR(45) NULL,
  `idRevistaInicial` INT NOT NULL,
  PRIMARY KEY (`idAprobacion`, `cedula_Editor`, `idArticulo`, `idRevistaInicial`),
  INDEX `fk_Aprobación_Editor1_idx` (`cedula_Editor` ASC) VISIBLE,
  INDEX `fk_Aprobación_Articulo1_idx` (`idArticulo` ASC) VISIBLE,
  INDEX `fk_Aprobación_Revista1_idx` (`idRevistaInicial` ASC) VISIBLE,
  CONSTRAINT `fk_Aprobación_Editor1`
    FOREIGN KEY (`cedula_Editor`)
    REFERENCES `Editorial`.`Editor` (`cedula_Editor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aprobación_Articulo1`
    FOREIGN KEY (`idArticulo`)
    REFERENCES `Editorial`.`Articulo` (`idArticulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aprobación_Revista1`
    FOREIGN KEY (`idRevistaInicial`)
    REFERENCES `Editorial`.`RevistaInicial` (`idRevistaInicial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`HistorialArticulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`HistorialArticulo` (
  `idHistorial Articulo` INT NOT NULL AUTO_INCREMENT,
  `idArticulo` INT NOT NULL,
  `Comentario` VARCHAR(200) NULL,
  `Estado` TINYINT NULL,
  PRIMARY KEY (`idHistorial Articulo`, `idArticulo`),
  INDEX `fk_Historial Articulo_Articulo1_idx` (`idArticulo` ASC) VISIBLE,
  CONSTRAINT `fk_Historial Articulo_Articulo1`
    FOREIGN KEY (`idArticulo`)
    REFERENCES `Editorial`.`Articulo` (`idArticulo`)
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
  `idMaquetacion` INT NOT NULL AUTO_INCREMENT,
  `fecha_Inicio` DATE NOT NULL,
  `fecha_Fin` DATE NOT NULL,
  `Comentario` VARCHAR(250) NULL,
  `idRevistaInicial` INT NOT NULL,
  PRIMARY KEY (`idMaquetacion`, `idRevistaInicial`),
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
  `cedula_Autor` VARCHAR(10) NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(10) NULL,
  `Dirección` VARCHAR(100) NOT NULL,
  `Correo` VARCHAR(128) NULL,
  `fecha_Nacimiento` DATE NOT NULL,
  PRIMARY KEY (`cedula_Autor`));


-- -----------------------------------------------------
-- Table `Editorial`.`Diseña`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Diseña` (
  `cedula_Autor` VARCHAR(10) NOT NULL,
  `idMaquetación` INT NOT NULL,
  PRIMARY KEY (`cedula_Autor`, `idMaquetación`),
  INDEX `fk_Diseñan_Maquetación1_idx` (`idMaquetación` ASC) VISIBLE,
  CONSTRAINT `fk_Diseñan_Diseñador1`
    FOREIGN KEY (`cedula_Autor`)
    REFERENCES `Editorial`.`Diseñador` (`cedula_Autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Diseñan_Maquetación1`
    FOREIGN KEY (`idMaquetación`)
    REFERENCES `Editorial`.`Maquetacion` (`idMaquetacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`RevistaFinal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`RevistaFinal` (
  `idRevistaFinal` INT NOT NULL AUTO_INCREMENT,
  `idMaquetacion` INT NOT NULL,
  `Tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idRevistaFinal`, `idMaquetacion`),
  INDEX `fk_RevistaFinal_Maquetación1_idx` (`idMaquetacion` ASC) VISIBLE,
  CONSTRAINT `fk_RevistaFinal_Maquetación1`
    FOREIGN KEY (`idMaquetacion`)
    REFERENCES `Editorial`.`Maquetacion` (`idMaquetacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Publicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Publicacion` (
  `idPublicacion` INT NOT NULL AUTO_INCREMENT,
  `fechaPublicacion` DATE NOT NULL,
  `Seccion` VARCHAR(45) NULL,
  `idRevistaFinal` INT NOT NULL,
  PRIMARY KEY (`idPublicacion`, `idRevistaFinal`),
  UNIQUE INDEX `Sección_UNIQUE` (`Seccion` ASC) VISIBLE,
  INDEX `fk_Publicación_RevistaFinal1_idx` (`idRevistaFinal` ASC) VISIBLE,
  CONSTRAINT `fk_Publicación_RevistaFinal1`
    FOREIGN KEY (`idRevistaFinal`)
    REFERENCES `Editorial`.`RevistaFinal` (`idRevistaFinal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- vista de titulos publicados con su sección --------
create view Titulo_Seccion as
	select ri.Titulo as Titulo, rf.Tipo as Tipo, rf.Seccion as Sección
    from (select ri.Titulo, ma.idMaquetacion
			from RevistaInicial ri join Maquetacion ma on ri.idRevistaInicial=ma.idRevistaInicial) ri join (select rf.Tipo, pu.Seccion, rf.idMaquetacion
																											from RevistaFinal rf join Publicacion pu on rf.idRevistaFinal=pu.idRevistaFinal) rf
		on ri.idMaquetacion=rf.idMaquetacion;
-- view que muestra el id, especialidad  con el articulo que escribio un periodistas
create view artículoXperiodista as
	select aut.cedula_Autor as cedulaAutor, aut.Nombre as Nombre, aut.Especialidad as Especialidad, art.Descripción as DescripcionArt
    from (select aut.cedula_Autor, aut.Nombre, aut.Especialidad, e.idArticulo
			from Autor aut join Escribe e on aut.cedula_Autor=e.cedula_Autor) aut join Articulo art on aut.idArticulo=art.idArticulo;


INSERT INTO Autor
VALUES ('0987629425', 'Michael', 'Estrabao', '3374832949', 'Acasias', null,'1999-01-01', 'Biología');

INSERT INTO Autor
VALUES ('0987629426', 'Carlos', 'Tingo', '8475629403', 'Acasias', null,'1999-04-10', 'Química');

INSERT INTO Autor
VALUES ('0987629427', 'Michelle', 'Estrabao', '2840593849', 'Acasias', 'micasan@espol.edu.ec','1999-11-01', 'Física');

INSERT INTO Autor
VALUES ('0987629428', 'Clara', 'Vera', '2849503758', 'Acasias', null,'2000-09-01', 'A.I.');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
