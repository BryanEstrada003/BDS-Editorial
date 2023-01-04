drop database if exists editorial;
create database melanie;
use melanie;

create table Empleado(
	cedula varchar(10) Primary key,
    nombre varchar(30),
    apellido varchar(30),
	cargo varchar(30),
    direccion varchar(30),
    contrato varchar(30),
    fechaNacimiento varchar(30),
    Edad int,
    Salario double
);

create table Sucursal(
	idSucursal int(3) Primary Key,
    correo varchar(40),
    direccion varchar(30)
);

create table Periodista(
	idPeriodistaExterno int(4) Primary key,
	cedula varchar(10),
    nombre varchar(30),
    apellido varchar(30),
	cargo varchar(30),
    direccion varchar(30),
    contrato varchar(30),
    fechaNacimiento varchar(30),
    Edad int,
    Salario double,
    Especialidad varchar(30)
);

create table TelefonoEmpleado(
	numTelefono int(10) primary key,
    cedula varchar(10),
    constraint foreign key (cedula) references Empleado(cedula)
);

create table TelefonoSucursal(
	numTelefono int(10) primary key,
    idSucursal int(3),
    constraint foreign key (idSucursal) references Sucursal(idSucursal)
);

create table HistorialEmpleado(
	idSucursal int(3),
    cedula varchar(10),
    fechaInicio varchar(30),
    fechaFin varchar(30),
    cargo varchar(30),
    primary key(idSucursal, cedula),
    constraint foreign key (idSucursal) references Sucursal (idSucursal),
    constraint foreign key (cedula) references Empleado (Cedula)
);


create table Articulo(
	idArticulo int(4) primary key,
    idPeriodistaExterno int(4),
    constraint foreign key (idPeriodistaExterno) references Periodista (idPeriodistaExterno)
);

create table Revista(
	numeroRegistroRevista int(4) primary key,
    idSucursal int(3),
    tipo varchar(20),
    periodicidad int,
    titulo varchar(40),
    constraint foreign key (idSucursal) references Sucursal (idSucursal)
);

create table HistorialArticulo(
	idHistorialArt int(4) primary key,
    idArticulo int(4),
    comentarios varchar(20),
    estado varchar(30),
    constraint foreign key (idArticulo) references Articulo (idArticulo) 
);

create table Ejemplar(
	numeroRegistroEjemplar int(4) primary key,
    numeroRegistroRevista int(4),
    numeroPaginas int,
    numeroVendidos int,
    fecha varchar(30),
	constraint foreign key (numeroRegistroRevista) references Revista (numeroRegistroRevista)
);

create table SeccionFija(
	titulo varchar(30) primary key,
    numeroRegistroRevista int(4),
    extension int,
    constraint foreign key (numeroRegistroRevista) references Revista(numeroRegistroRevista)
);

create table Aprobacion(
	idAprobacion int(4) primary key,
    cedula varchar(10),
    idArticulo int(4),
    numeroRegistroRevista int(4),
    seccionPublicar varchar(30),
    estado varchar(30),
    constraint foreign key (cedula) references Empleado (Cedula),
    constraint foreign key (idArticulo) references Articulo (idArticulo),
	constraint foreign key (numeroRegistroRevista) references Revista(numeroRegistroRevista)
);

-- Esta es la vista que muestra el número de ejemplares vendidos por revista
create view ejempXrevist as select r.titulo as Titulo, e.numeroVendidos as NumeroVenta 
from ejemplar e join revista r on e.numeroRegistroRevista = r.numeroRegistroRevista
group by r.numeroregistroRevista;

-- Estos son los pasos para crear la vista de nomTitSecc
select r.titulo as revistaTitulo, s.titulo seccionTitulo, r.numeroRegistroRevista 
from revista r join seccionfija s on r.numeroRegistroRevista = s.numeroRegistroRevista;

select e.nombre, a.numeroRegistroRevista 
from aprobacion a join empleado e on a.cedula = e.cedula;


select t.nombre, r.revistaTitulo, r.seccionTitulo 
from (select e.nombre, a.numeroRegistroRevista 
		from aprobacion a join empleado e on a.cedula = e.cedula) t join (select r.titulo as revistaTitulo, s.titulo seccionTitulo, r.numeroRegistroRevista 
																			from revista r join seccionfija s on r.numeroRegistroRevista = s.numeroRegistroRevista) r 
	on t.numeroRegistroRevista = r.numeroRegistroRevista;

-- Esta es la view de nombre con titulo de revista y título de seccion
drop view if exists nomTitSecc;
create view nomTitSecc as select t.nombre as Nombre, r.revistaTitulo as Titulo, r.seccionTitulo as SeccionPublicar 
from (select e.nombre, a.numeroRegistroRevista 
		from aprobacion a join empleado e on a.cedula = e.cedula) t join (select r.titulo as revistaTitulo, s.titulo seccionTitulo, r.numeroRegistroRevista 
																			from revista r join seccionfija s on r.numeroRegistroRevista = s.numeroRegistroRevista) r 
	on t.numeroRegistroRevista = r.numeroRegistroRevista;

 -- view que muestra el id, especialidad  con el articulo que escribio un periodistas
 create view artsPeridodista
as select p.idPeriodistaExterno as idPeriodistaExterno,p.nombre as Nombre , p.Especialidad as Especialidad, a.idArticulo as idArticulo from periodista p
    join articulo a on p.idPeriodistaExterno=a.idPeriodistaExterno
    group by p.idPeriodistaExterno, p.Especialidad, a.idArticulo;


create view historialEmp as select t.idSucursal,t.fechaInicio,t.fechaFin,e.nombre,e.apellido,e.cedula 
from (select  s.idSucursal,he.cedula,he.fechaInicio,he.fechaFin 
from sucursal s join historialempleado he on s.idSucursal = he.idsucursal) t 
join empleado e on t.cedula=e.cedula;

delimiter //
create trigger editarHistorialEmpleado after update
on historialempleado for each row
begin
	insert into historialempleado(idSucursal, cedula, fechaInicio, fechaFin, cargo) 
    values (new.idSucursal ,new.cedula , new.fechaInicio, new.fechaFin, new.cargo );
end //
delimiter ; 


delimiter &&
create trigger  actualizarAprobacion after insert 
on historialarticulo
for each row
begin
	update aprobacion set Estado = new.estado where idAprobacion = idArticulo;
end &&
delimiter ;

delimiter $
create procedure verificarEstado(in identificadorArticulo int, out estadoArt varchar(30))
begin
	select estado from historialArticulo where idArticulo = identificadorArticulo;
end$
delimiter ;

delimiter %
create procedure agregarSucursales(in identificador int, in correoSucursal varchar(50), in direccionSucursal varchar(50))
begin
	Insert into Sucursal values (identificador, correoSucursal, direccionSucursal); 
end %
delimiter ;

-- Prueba del procedura
-- call agregarSucursales(4,"suc4@hotmail.com","Avenida Quito");
-- call agregarSucursales(5,"suc5@hotmail.com","Avenida Domingo Comín");