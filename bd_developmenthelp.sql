CREATE DATABASE forum;

USE forum;

CREATE TABLE tbl_usuario(
	cod_usuario int PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) UNIQUE,
    email varchar(255) UNIQUE,
    senha varchar(255),
    linkedin varchar(255),
    github varchar(255),
    biografia varchar(255)
);

CREATE TABLE tbl_pergunta(
	cod_pergunta int PRIMARY KEY AUTO_INCREMENT,
    titulo varchar(255),
    conteudo varchar(4000),
    cod_usuario int,
    FOREIGN KEY (cod_usuario) REFERENCES tbl_usuario (cod_usuario) 
);