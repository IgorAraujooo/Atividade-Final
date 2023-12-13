create database AtividadeFinal;
use AtividadeFinal;

create table clientes(
id integer not null auto_increment primary key,
nome varchar(255),
cpf varchar(11),
email varchar(255)
);

insert into clientes(nome, email, cpf) values 
("Igor", "igor@gmail.com", "12345678901"),
("Calsolari", "calsolari@gmail.com", "23456789012"),
("Mineiro", "mineiro@gmail.com", "34567890123"),
("Zanoni", "zanoni@gmail.com", "45678901234"),
("Paiva", "juliapaiva@gmail.com", "56789012345"),
("Giovana", "vdc@gmail.com", "67890123456"),
("Luan", "dso@gmail.com", "78901234567");



create table produtos(
id integer not null auto_increment primary key,
nome varchar(255),
quantidade int,
preco integer,
descricao varchar(555),
atributo varchar(255),
fornecedor varchar(255)
);

insert into produtos(nome, descricao, atributo, fornecedor, quantidade, preco) values
("Mouse sem Fio", "Geek", "sem fio", "CCXS", 50, 48),
("Teclado RGB", "Iluminação RGB", "com fio", "CCXS", 30, 97),
("Monitor HD LED", "Alta definição", "led", "FPg", 10, 128),
("Notebook Portátil", "Pequeno portátil", "hd", "RRXS", 5, 2098),
("Pendrive Wireless", "Dispositivo periférico", "wireless", "RRXS", 100, 68),
("Fonte de Alimentação", "Carregador notebook GP6", "de fio", "EletornicS", 20, 128);


create table compra(
id integer not null auto_increment primary key,
clientes_id int,
produtos_id int,
foreign key(produtos_id) references produtos(id),
foreign key(clientes_id) references clientes(id)
);

select * from clientes;

