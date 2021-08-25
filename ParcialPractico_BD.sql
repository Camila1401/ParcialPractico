CREATE DATABASE if not exists scoobydoo;

use scoobydoo;

create table if not exists usuario(
	nombreUsuario varchar(20) NOT NULL,
    dniUsuario int NOT NULL,
    mail varchar(20) NOT NULL,
    premium boolean NOT NULL,
    primary key (dniUsuario)
);

create table if not exists prestamo(
	id int NOT NULL,
    dias int,
    diasPrestado int,
    multa int,
    dniUsuario int NOT NULL,
    primary key (id),
    constraint dniUsuario foreign key (dniUsuario) REFERENCES usuario (dniUsuario)
);

create table if not exists libro(
	id int NOT NULL, 
    genero int NOT NULL,
    titulo varchar(20) NOT NULL,
    primary key (id)
);

create table if not exists copia(
	id int NOT NULL,
    dias int,
    idPrestamo int NOT NULL,
    idLibro int NOT NULL,
    primary key (id),
    constraint idPrestamo foreign key (idPrestamo) REFERENCES prestamo (id),
    constraint idLibro foreign key (idLibro) REFERENCES libro (id)
);

--ALTER TABLE prestamo MODIFY (id) int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;