SET search_path TO projet;
-- Schéma
DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet AUTHORIZATION projet;
GRANT ALL PRIVILEGES ON SCHEMA projet TO projet;

-- Tables

CREATE TABLE compte (
	IdCompte		INT			 	NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
	Pseudo			VARCHAR(25)		NOT NULL,
	MotDePasse		VARCHAR(25) 	NOT NULL,
	Email			VARCHAR(100)	NOT NULL,
	Solde			INT				NOT NULL,
	PRIMARY KEY (IdCompte)
);

CREATE UNIQUE INDEX idx_compte_pseudo ON compte (Pseudo ASC);



CREATE TABLE salle (
IdSalle	INT	NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
NombreSalle int NOT NULL,
PRIMARY KEY (IdSalle)
);

CREATE TABLE cours (
IdCours	INT	NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
Prix float NOT NULL,
	IdSalle		INT				NOT NULL,
Libelle varchar(25) NOT NULL,
Capacite  int NOT NULL,
Crenaux varchar(25) NOT NULL,
CHECK( Crenaux  IN ('MATIN_DIMANCHE','MATIN_SAMEDI','APRESMIDI_DIMANCHE','APRESMIDI_SAMEDI') ),
FOREIGN KEY (IdSalle) REFERENCES salle (IdSalle),
PRIMARY KEY (IdCours)
);
CREATE TABLE mouvement (
IdMouvement	INT	NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
Prix float NOT NULL,
	IdCompte		INT				NOT NULL,
FOREIGN KEY (IdCompte) REFERENCES compte (IdCompte),
PRIMARY KEY (IdMouvement)
);
CREATE TABLE enfant (
IdEnfant	INT	NOT NULL	GENERATED BY DEFAULT AS IDENTITY,
Nom			VARCHAR(25)	NOT NULL,
	IdCompte		INT				NOT NULL,
	IdCours		INT				,
	
Prenom		VARCHAR(25) 	NOT NULL,
DateDeNaissance	date	NOT NULL,
NiveauEtude	VARCHAR(100)	NOT NULL,
Creneau	VARCHAR(100)	NOT NULL,
MethodePayement	VARCHAR(100) NOT NULL,
FOREIGN KEY (IdCompte) REFERENCES compte (IdCompte),
FOREIGN KEY (IdCours) REFERENCES cours (IdCours),
PRIMARY KEY (IdEnfant)
);

CREATE TABLE role (
	IdCompte		INT				NOT NULL,
	Role			VARCHAR(20)		NOT NULL,
	CHECK( Role IN ('ADMINISTRATEUR','UTILISATEUR') ),	
	FOREIGN KEY (IdCompte) REFERENCES compte (IdCompte),
	PRIMARY KEY (IdCompte, Role)
);
