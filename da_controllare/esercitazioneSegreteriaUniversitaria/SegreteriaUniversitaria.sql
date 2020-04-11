drop table if exists studente;
create table studente(
	matricola varchar(20) auto_increment primary key,
	nome varchar(45) not null,
	cognome varchar(45) not null,
	data_di_nascita date not null,
	nome_facolta varchar(45) not null
	);
	
	drop table if exists facolta;
create table facolta(
	codice_facolta varchar(20) primary key,
	nome_facolta varchar(45) not null,
	numero_iscritti int auto_increment
	--,
	
	
	--CONSTRAINT FK_facolta_studente
	--	foreign key (nome_facolta) REFERENCES studente(matricola)
	);
	
	insert into facolta (codice_facolta, nome_facolta)
	values ('1234', 'Filosofia');
	 
	 insert into facolta (codice_facolta, nome_facolta)
	values ('1235', 'Matematica');
	
	 insert into facolta (codice_facolta, nome_facolta)
	values ('1224', 'Fisica');
	
	 insert into facolta (codice_facolta, nome_facolta)
	values ('1236', 'Storia');
	
	 insert into facolta (codice_facolta, nome_facolta)
	 values ('1237', 'Ingegneria');
	 
	 insert into facolta (codice_facolta, nome_facolta)
	 values ('1238', 'Lettere');
	 
	 insert into facolta (codice_facolta, nome_facolta)
	values ('1239', 'Astronomia');
	 
	 insert into facolta (codice_facolta, nome_facolta)
	 values ('1240', 'Scienze Umane');
	 
	 insert into facolta (codice_facolta, nome_facolta)
	values ('1241', 'Marketing');