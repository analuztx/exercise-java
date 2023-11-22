CREATE DATABASE atividade_8;
USE atividade_8;

CREATE TABLE usuario(
	id int(4) auto_increment primary key,
    nome varchar(50),
    email varchar(50),
    login varchar(50),
    senha varchar(50)
);

CREATE TABLE produto(
	id int(4) auto_increment primary key,
    nomeProduto varchar(50),
    descricao varchar(50)
);

CREATE TABLE venda(
	id int(4) auto_increment primary key,
    nomeVendedor varchar(50),
    produtoVendido varchar(50)
);

select * from ex1;

drop table atividade_8.ex1;

drop database atividade_8;