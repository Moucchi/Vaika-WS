CREATE TABLE IF NOT EXISTS utilisateur
(
    id            SERIAL PRIMARY KEY,
    nom           VARCHAR(250),
    email         VARCHAR(250) NOT NULL,
    mot_de_passe  VARCHAR(250) NOT NULL,
    porte_feuille DOUBLE PRECISION DEFAULT 0
);

CREATE TABLE IF NOT EXISTS marque
(
    id  SERIAL PRIMARY KEY,
    nom VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS transmission
(
    id  SERIAL PRIMARY KEY,
    nom VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS carburant
(
    id  SERIAL PRIMARY KEY,
    nom VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS categorie
(
-- SUV ,
-- Berline ,
-- Break ,
-- Monospace ,
-- Coupé ,
-- Cabriolet ,
-- Citadine ,
-- 4x4 ,
-- Utilitaire ,
-- Camion ,
-- Autre
    id  SERIAL PRIMARY KEY,
    nom VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS modele
(
    id           SERIAL PRIMARY KEY,
    nom          VARCHAR(200) NOT NULL,
    id_marque    INTEGER      NOT NULL,
    id_categorie INTEGER      NOT NULL,
    CONSTRAINT fk_marque FOREIGN KEY (id_marque) REFERENCES marque (id),
    CONSTRAINT fk_categorie FOREIGN KEY (id_categorie) REFERENCES categorie (id)
);

CREATE TABLE IF NOT EXISTS detail_model
(
    id_model        INTEGER          NOT NULL,
    annee           INTEGER          NOT NULL,
    id_transmission INTEGER          NOT NULL,
    id_carburant    INTEGER          NOT NULL,
    puissance       DOUBLE PRECISION NOT NULL,
    place           INTEGER          NOT NULL,
    consommation    DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (id_model) REFERENCES modele (id),
    FOREIGN KEY (id_transmission) REFERENCES transmission (id),
    FOREIGN KEY (id_carburant) REFERENCES carburant (id)
);

CREATE TABLE IF NOT EXISTS voiture
(
    id          SERIAL          PRIMARY KEY,
    annee_circulation           INTEGER NOT NULL,
    id_modele                   INTEGER         NOT NULL,
    kilometrage                 INTEGER         NOT NULL,
    couleur                     VARCHAR(200)    NOT NULL,
    FOREIGN KEY (id_modele)     REFERENCES modele (id)
);

CREATE TABLE IF NOT EXISTS historique_voiture
(
    id_voiture INTEGER NOT NULL,
    id_proprio INTEGER NOT NULL,
    date_achat DATE    NOT NULL,
    FOREIGN KEY (id_voiture) REFERENCES voiture (id),
    FOREIGN KEY (id_proprio) REFERENCES utilisateur (id)
);

CREATE TABLE IF NOT EXISTS annonce
(
    id         SERIAL PRIMARY KEY,
    id_voiture INTEGER          NOT NULL,
    id_vendeur INTEGER          NOT NULL,
    prix       DOUBLE PRECISION NOT NULL,
    date       DATE             NOT NULL,
    FOREIGN KEY (id_voiture) REFERENCES voiture (id),
    FOREIGN KEY (id_vendeur) REFERENCES utilisateur (id)
);

CREATE TABLE IF NOT EXISTS etat_annonce
(
    id_annonce INTEGER NOT NULL,
    etat       INTEGER NOT NULL, -- 0 : indisponnible , 1 : disponible , 2 : vendu
    FOREIGN KEY (id_annonce) REFERENCES annonce (id)
);

CREATE TABLE IF NOT EXISTS favoris
(
    id_utilisateur INTEGER NOT NULL,
    id_annonce     INTEGER NOT NULL,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id),
    FOREIGN KEY (id_annonce) REFERENCES annonce (id)
);

CREATE TABLE IF NOT EXISTS tag
(
    id  SERIAL PRIMARY KEY,
    nom VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS tag_annonce
(
    id_tag     INTEGER NOT NULL,
    id_annonce INTEGER NOT NULL,
    FOREIGN KEY (id_tag) REFERENCES tag (id),
    FOREIGN KEY (id_annonce) REFERENCES annonce (id)
);