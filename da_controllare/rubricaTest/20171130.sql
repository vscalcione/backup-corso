drop table if exists contacts;
create table persona(
	id int auto_increment primary key,
	nome varchar(45) not null,
	surname varchar(45) not null
	
	);
	
	
	
	
	
	drop table if exists email;
create table email(
	id int auto_increment primary key,
	contacts_id integer  not null,
	types varchar(45) not null,
	email varchar(45) not null,
	
	CONSTRAINT FK_email_contacts
		foreign key (contacts_id) REFERENCES persona(id)
	
	);
	
	
	
		drop table if exists phone;
create table phone(
	id int auto_increment primary key,
	contacts_id integer  not null,
	types varchar(45) not null,
	phone varchar(45) not null,
	
	CONSTRAINT FK_phone_contacts
		foreign key (contacts_id) REFERENCES persona(id)
	
	);
	
	
	
	
	
	
	
	
	
	