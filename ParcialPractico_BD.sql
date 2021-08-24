CREATE DATABASE if not exists scoobydoo;

create table usuario(
	nombreUsuario varchar(20),
    dni int,
    mail varchar(20),
    premium boolean
);