-- -----------------------------------------------------------------------------
--             G�n�ration d'une base de donn�es pour
--                           PostgreSQL
--                        (17/11/2023 14:42:43)
-- -----------------------------------------------------------------------------
--      Nom de la base : basket
--      Projet : 
--      Auteur : Judicael
--      Date de derni�re modification : 17/11/2023 14:40:25
-- -----------------------------------------------------------------------------

drop database basket;
-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE basket;

-- -----------------------------------------------------------------------------
--       TABLE : JOUEUR
-- -----------------------------------------------------------------------------

CREATE TABLE JOUEUR
   (
    IDJOUEUR  serial  ,
    NOM varchar(128) NULL  ,
    PRENOM varchar(128) NULL  
,   CONSTRAINT PK_JOUEUR PRIMARY KEY (IDJOUEUR)
   );

-- -----------------------------------------------------------------------------
--       TABLE : EQUIPE
-- -----------------------------------------------------------------------------

CREATE TABLE EQUIPE
   (
    IDEQUIPE serial  ,
    NOM varchar(50) NULL  
,   CONSTRAINT PK_EQUIPE PRIMARY KEY (IDEQUIPE)
   );

-- -----------------------------------------------------------------------------
--       TABLE : MATCH
-- -----------------------------------------------------------------------------

CREATE TABLE MATCH
   (
    IDMATCH serial  ,
    IDEQUIPE_EXTERIEUR int NOT NULL  ,
    IDEQUIPE_DOMICILE int NOT NULL  ,
    DEBUT timestamp(12) NULL  
,   CONSTRAINT PK_MATCH PRIMARY KEY (IDMATCH)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE MATCH
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_MATCH_EQUIPE
     ON MATCH (IDEQUIPE_EXTERIEUR)
    ;

CREATE  INDEX I_FK_MATCH_EQUIPE2
     ON MATCH (IDEQUIPE_DOMICILE)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : REBOND
-- -----------------------------------------------------------------------------

CREATE TABLE REBOND
   (
    IDMATCH int NOT NULL  ,
    IDJOUEUR int NOT NULL  ,
    TYPE int2 NULL  
,   CONSTRAINT PK_REBOND PRIMARY KEY (IDMATCH, IDJOUEUR)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE REBOND
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_REBOND_MATCH
     ON REBOND (IDMATCH)
    ;

CREATE  INDEX I_FK_REBOND_JOUEUR
     ON REBOND (IDJOUEUR)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : PASSEDECISIVE
-- -----------------------------------------------------------------------------

CREATE TABLE PASSEDECISIVE
   (
    IDMATCH int NOT NULL  ,
    IDJOUEUR int NOT NULL
,   CONSTRAINT PK_PASSEDECISIVE PRIMARY KEY (IDMATCH, IDJOUEUR)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE PASSEDECISIVE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_PASSEDECISIVE_MATCH
     ON PASSEDECISIVE (IDMATCH)
    ;

CREATE  INDEX I_FK_PASSEDECISIVE_JOUEUR
     ON PASSEDECISIVE (IDJOUEUR)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : TIR
-- -----------------------------------------------------------------------------

CREATE TABLE TIR
   (
    IDMATCH int NOT NULL  ,
    IDJOUEUR int NOT NULL  ,
    TYPE int NULL  ,
    MATY boolean NULL
,   CONSTRAINT PK_TIR PRIMARY KEY (IDMATCH, IDJOUEUR)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE TIR
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_TIR_MATCH
     ON TIR (IDMATCH)
    ;

CREATE  INDEX I_FK_TIR_JOUEUR
     ON TIR (IDJOUEUR)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : EQUIPEJOUEUR
-- -----------------------------------------------------------------------------

CREATE TABLE EQUIPEJOUEUR
   (
    IDEQUIPE int NOT NULL  ,
    IDJOUEUR int NOT NULL  ,
    NUMERO int NULL  ,
    POSTE varchar(128) NULL  
,   CONSTRAINT PK_EQUIPEJOUEUR PRIMARY KEY (IDEQUIPE, IDJOUEUR)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE EQUIPEJOUEUR
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_EQUIPEJOUEUR_EQUIPE
     ON EQUIPEJOUEUR (IDEQUIPE)
    ;

CREATE  INDEX I_FK_EQUIPEJOUEUR_JOUEUR
     ON EQUIPEJOUEUR (IDJOUEUR)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : REMPLACEMENT
-- -----------------------------------------------------------------------------

CREATE TABLE REMPLACEMENT
   (
    IDMATCH int NOT NULL  ,
    IDJOUEURA int NOT NULL  ,
    IDJOUEURB int NOT NULL  ,
    HEURE time(4) NULL
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE REMPLACEMENT
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_REMPLACEMENT_MATCH
     ON REMPLACEMENT (IDMATCH)
    ;

CREATE  INDEX I_FK_REMPLACEMENT_JOUEURA
     ON REMPLACEMENT (IDJOUEURA)
    ;
CREATE  INDEX I_FK_REMPLACEMENT_JOUEURB
    ON REMPLACEMENT (IDJOUEURB)
;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE MATCH ADD 
     CONSTRAINT FK_MATCH_EQUIPE
          FOREIGN KEY (IDEQUIPE_EXTERIEUR)
               REFERENCES EQUIPE (IDEQUIPE);

ALTER TABLE MATCH ADD 
     CONSTRAINT FK_MATCH_EQUIPE2
          FOREIGN KEY (IDEQUIPE_DOMICILE)
               REFERENCES EQUIPE (IDEQUIPE);

ALTER TABLE REBOND ADD 
     CONSTRAINT FK_REBOND_MATCH
          FOREIGN KEY (IDMATCH)
               REFERENCES MATCH (IDMATCH);

ALTER TABLE REBOND ADD 
     CONSTRAINT FK_REBOND_JOUEUR
          FOREIGN KEY (IDJOUEUR)
               REFERENCES JOUEUR (IDJOUEUR);

ALTER TABLE PASSEDECISIVE ADD 
     CONSTRAINT FK_PASSEDECISIVE_MATCH
          FOREIGN KEY (IDMATCH)
               REFERENCES MATCH (IDMATCH);

ALTER TABLE PASSEDECISIVE ADD 
     CONSTRAINT FK_PASSEDECISIVE_JOUEUR
          FOREIGN KEY (IDJOUEUR)
               REFERENCES JOUEUR (IDJOUEUR);

ALTER TABLE TIR ADD 
     CONSTRAINT FK_TIR_MATCH
          FOREIGN KEY (IDMATCH)
               REFERENCES MATCH (IDMATCH);

ALTER TABLE TIR ADD 
     CONSTRAINT FK_TIR_JOUEUR
          FOREIGN KEY (IDJOUEUR)
               REFERENCES JOUEUR (IDJOUEUR);

ALTER TABLE EQUIPEJOUEUR ADD 
     CONSTRAINT FK_EQUIPEJOUEUR_EQUIPE
          FOREIGN KEY (IDEQUIPE)
               REFERENCES EQUIPE (IDEQUIPE);

ALTER TABLE EQUIPEJOUEUR ADD 
     CONSTRAINT FK_EQUIPEJOUEUR_JOUEUR
          FOREIGN KEY (IDJOUEUR)
               REFERENCES JOUEUR (IDJOUEUR);

ALTER TABLE REMPLACEMENT ADD 
     CONSTRAINT FK_REMPLACEMENT_MATCH
          FOREIGN KEY (IDMATCH)
               REFERENCES MATCH (IDMATCH);

ALTER TABLE REMPLACEMENT ADD 
     CONSTRAINT FK_REMPLACEMENT_JOUEURA
          FOREIGN KEY (IDJOUEURA)
               REFERENCES JOUEUR (IDJOUEUR);
ALTER TABLE REMPLACEMENT ADD
    CONSTRAINT FK_REMPLACEMENT_JOUEURB
        FOREIGN KEY (IDJOUEURB)
            REFERENCES JOUEUR (IDJOUEUR);


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------