-- Creazione della tabella Facoltà
drop table Facolta if exists;
create table Facolta(
	id_facolta varchar(20) not null primary key,
	nome_facolta varchar(45) not null,
	numero_iscritti int auto_increment
);

-- Creazione della tabella Studente
drop table Studente if exists;
create table Studente(
	matricola varchar(20) auto_increment primary key,
	nome_studente varchar(20) not null,
	cognome_studente varchar(20) not null,
	data_nascita date not null,
	email varchar(50) not null,
	nome_facolta varchar(45) not null,
	foreign key (nome_facolta) references Facolta(nome_facolta);
);
