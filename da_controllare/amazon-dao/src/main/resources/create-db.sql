-- -----------------------------------------------------
-- TABLE `CATEGORY`
-- -----------------------------------------------------
DROP TABLE CATEGORY IF EXISTS CASCADE;
CREATE TABLE CATEGORY(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_padre INT,
	nome VARCHAR(45) NOT NULL,
  FOREIGN KEY (id_padre) REFERENCES CATEGORY (id)
);

-- -----------------------------------------------------
-- TABLE `PRODUCT`
-- -----------------------------------------------------
DROP TABLE PRODUCT IF EXISTS CASCADE;
CREATE TABLE PRODUCT (
  asin VARCHAR(50) NOT NULL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  descrizione VARCHAR(2000) NOT NULL,
  marca VARCHAR(45) NOT NULL,
  modello VARCHAR(45) NOT NULL,
  id_categoria INT NOT NULL,
  FOREIGN KEY (id_categoria) REFERENCES CATEGORY (id)
);

-- -----------------------------------------------------
-- TABLE `SELLER`
-- -----------------------------------------------------
DROP TABLE SELLER IF EXISTS CASCADE;
CREATE TABLE SELLER (
	p_iva VARCHAR(20) NOT NULL PRIMARY KEY,
	nome VARCHAR(45) NOT NULL,
	nazione VARCHAR(45) NOT NULL
);

-- -----------------------------------------------------
-- TABLE `PRODUCT_SELLER`
-- -----------------------------------------------------
DROP TABLE PRODUCT_SELLER IF EXISTS CASCADE;
CREATE TABLE PRODUCT_SELLER (
	asin VARCHAR(50) NOT NULL,
	p_iva VARCHAR(20) NOT NULL,
	prezzo DOUBLE NULL,
	pezzi_disponibili INT NULL,
	PRIMARY KEY(asin, p_iva),
	FOREIGN KEY (asin) REFERENCES PRODUCT (asin),
	FOREIGN KEY (p_iva) REFERENCES SELLER (p_iva)
);

-- -----------------------------------------------------
-- TABLE `SHIPMENT_PROFILE`
-- -----------------------------------------------------
DROP TABLE SHIPMENT_PROFILE IF EXISTS CASCADE;
CREATE TABLE SHIPMENT_PROFILE (
	nome VARCHAR(50) NOT NULL PRIMARY KEY,
	prezzo DOUBLE NOT NULL,
	giorni_spedizione INT NULL
);

-- -----------------------------------------------------
-- TABLE `PRODUCT_SHIPPER_PROFILE`
-- -----------------------------------------------------
DROP TABLE PRODUCT_SHIPMENT_PROFILE IF EXISTS CASCADE;
CREATE TABLE PRODUCT_SHIPMENT_PROFILE (
	asin VARCHAR(50) NOT NULL,
	p_iva VARCHAR(20) NOT NULL,
	nome_spedizione VARCHAR(50) NOT NULL,
	PRIMARY KEY (asin, p_iva, nome_spedizione),
	FOREIGN KEY (asin, p_iva) REFERENCES PRODUCT_SELLER (asin, p_iva),
	FOREIGN KEY (nome_spedizione) REFERENCES SHIPMENT_PROFILE (nome)
);

-- -----------------------------------------------------
-- TABLE `USER`
-- -----------------------------------------------------
DROP TABLE USER IF EXISTS CASCADE;
CREATE TABLE USER (
	username VARCHAR(20) NOT NULL PRIMARY KEY,
	email VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(45) NOT NULL,
);

-- -----------------------------------------------------
-- TABLE `ADDRESS`
-- -----------------------------------------------------
DROP TABLE ADDRESS IF EXISTS CASCADE;
CREATE TABLE ADDRESS (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(20) NOT NULL,
	nominativo VARCHAR(100) NOT NULL,
	via VARCHAR(200) NOT NULL,
	cap CHAR(5) NOT NULL,
	citta VARCHAR(150) NOT NULL,
	provincia VARCHAR(2) NOT NULL,
	nazione VARCHAR(20) NOT NULL,
	numero_telefono VARCHAR(20) NOT NULL,
	FOREIGN KEY (username) REFERENCES USER (username)
);

-- -----------------------------------------------------
-- TABLE `ORDER`
-- -----------------------------------------------------
DROP TABLE ORDER IF EXISTS CASCADE;
CREATE TABLE ORDER (
	numero_ordine INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	stato_pagamento VARCHAR(20) NULL,
	modalita_pagamento VARCHAR(20) NULL,
	sconto INT NULL,
	username VARCHAR(20) NOT NULL,
	indirizzo_id INT NOT NULL,
	FOREIGN KEY (username) REFERENCES USER (username),
	FOREIGN KEY (indirizzo_id) REFERENCES ADDRESS (id)
);

-- -----------------------------------------------------
-- TABLE `PRODUCT_ORDER`
-- -----------------------------------------------------
DROP TABLE PRODUCT_ORDER IF EXISTS CASCADE;
CREATE TABLE PRODUCT_ORDER (
	numero_ordine INT NOT NULL,
	asin VARCHAR(20) NOT NULL,
	p_iva VARCHAR(20) NOT NULL,
	quantita INT NOT NULL,
	prezzo_acquisto DOUBLE NULL,
	sconto INT NULL,
	nome_profilo_spedizione VARCHAR(50) NOT NULL,
	PRIMARY KEY (numero_ordine, asin, p_iva),
	FOREIGN KEY (numero_ordine) REFERENCES ORDER (numero_ordine)
	FOREIGN KEY (asin) REFERENCES PRODUCT (asin)
	FOREIGN KEY (p_iva , asin) REFERENCES PRODUCT_SELLER (p_iva , asin)
	FOREIGN KEY (nome_profilo_spedizione) REFERENCES SHIPMENT_PROFILE (name)
);


-- -----------------------------------------------------
-- TABLE `PRODUCT_REVIEW`
-- -----------------------------------------------------
DROP TABLE PRODUCT_REVIEW IF EXISTS CASCADE;
CREATE TABLE PRODUCT_REVIEW (
	username VARCHAR(20) NOT NULL,
	asin VARCHAR(50) NOT NULL,
	punteggio INT NOT NULL,
	titolo VARCHAR(100) NULL,
	testo VARCHAR(2000) NULL,
	PRIMARY KEY (username, asin),
	FOREIGN KEY (username) REFERENCES USER (username),
	FOREIGN KEY (asin) REFERENCES PRODUCT (asin)
);

-- -----------------------------------------------------
-- Table `SELLER_REVIEW`
-- -----------------------------------------------------
DROP TABLE SELLER_REVIEW IF EXISTS CASCADE;
CREATE TABLE SELLER_REVIEW (
	username VARCHAR(20) NOT NULL,
	p_iva VARCHAR(20) NOT NULL,
	punteggio INT NOT NULL,
	titolo VARCHAR(100) NULL,
	testo VARCHAR(2000) NULL,
	PRIMARY KEY (username, p_iva),
	FOREIGN KEY (username) REFERENCES USER(username),
	FOREIGN KEY (p_iva) REFERENCES SELLER(p_iva)
);
