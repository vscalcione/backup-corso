--- Creazione della tabella Activity
DROP TABLE ACTIVITY IF EXISTS CASCADE;
CREATE TABLE ACTIVITY(
	id_activity varchar(36) PRIMARY KEY,
	activity_name varchar(100) not null,
	start_date date,
	end_date date,	
);





--- Creazione della tabella Employee
DROP TABLE EMPLOYEE IF EXISTS CASCADE;
CREATE TABLE EMPLOYEE(
	id_matricola int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	name varchar(100) not null,
	surname varchar(100) not null,
);




-- Creazione tabella di correlazione
DROP TABLE ACTIVITY_EMPLOYEE IF EXISTS CASCADE;
CREATE TABLE ACTIVITY_EMPLOYEE(
	id_matricola int,
	id_activity VARCHAR(100) NOT NULL,
	FOREIGN KEY (id_matricola) REFERENCES employee(id_matricola),
	FOREIGN KEY(id_activity) REFERENCES activity(id_activity),
	PRIMARY KEY(id_matricola,id_activity)
);