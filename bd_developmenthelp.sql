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

CREATE TABLE tbl_resposta(
	cod_resposta int PRIMARY KEY AUTO_INCREMENT,
    dsc_resposta varchar(255),
    cod_usuario int,
    cod_pergunta int,
    is_favorita boolean DEFAULT false,
    FOREIGN KEY (cod_usuario) REFERENCES tbl_usuario (cod_usuario),
    FOREIGN KEY (cod_pergunta) REFERENCES tbl_pergunta (cod_pergunta)
);