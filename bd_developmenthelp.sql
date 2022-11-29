CREATE DATABASE bd_developmenthelp;

USE bd_developmenthelp;

CREATE TABLE tbl_usuario(
	cod_usuario int PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) UNIQUE,
    email varchar(255) UNIQUE,
    senha varchar(255),
    linkedin varchar(255),
    github varchar(255),
    biografia varchar(255)
);

CREATE TABLE tbl_categoria(
	cod_categoria int PRIMARY KEY AUTO_INCREMENT,
    dsc_categoria varchar(255)
);

CREATE TABLE tbl_pergunta(
	cod_pergunta int PRIMARY KEY AUTO_INCREMENT,
    dsc_pergunta varchar(500),
    cod_usuario int,
    cod_categoria int,
    FOREIGN KEY (cod_usuario) REFERENCES tbl_usuario (cod_usuario),
    FOREIGN KEY (cod_categoria) REFERENCES tbl_categoria (cod_categoria) 
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

CREATE TABLE tbl_artigo(
	cod_artigo int PRIMARY KEY AUTO_INCREMENT,
    dsc_titulo varchar(255),
    dsc_conteudo varchar(2550),
    cod_usuario int,
    cod_categoria int,
    FOREIGN KEY (cod_usuario) REFERENCES tbl_usuario (cod_usuario),
    FOREIGN KEY (cod_categoria) REFERENCES tbl_categoria (cod_categoria)     
);

CREATE TABLE tbl_comentario(
	cod_comentario int PRIMARY KEY AUTO_INCREMENT,
    dsc_comentario varchar(255),
    cod_artigo int,
    FOREIGN KEY (cod_artigo) REFERENCES tbl_artigo (cod_artigo)
);

CREATE TABLE tbl_curtida(
	cod_usuario int,
    cod_artigo int,
    PRIMARY KEY (cod_usuario, cod_artigo),
    FOREIGN KEY (cod_usuario) REFERENCES tbl_usuario (cod_usuario),
    FOREIGN KEY (cod_artigo) REFERENCES tbl_artigo (cod_artigo)
);

CREATE TABLE tbl_grupo(
	cod_grupo int PRIMARY KEY AUTO_INCREMENT,
    nom_grupo varchar(255),
    dsc_grupo varchar(255),
    is_privado boolean,
    cod_criador int,
    FOREIGN KEY (cod_criador) REFERENCES tbl_usuario (cod_usuario)
);

CREATE TABLE tbl_usuario_grupo(
	cod_grupo int,
    cod_usuario int,
    is_admin boolean,
    PRIMARY KEY (cod_grupo, cod_usuario),
    FOREIGN KEY (cod_grupo) REFERENCES tbl_grupo (cod_grupo),
    FOREIGN KEY (cod_usuario) REFERENCES tbl_usuario (cod_usuario)
);