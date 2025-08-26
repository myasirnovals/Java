show databases;

create database belajar_pzn_belajar_java_databases_latihan1;

use belajar_pzn_belajar_java_databases_latihan1;

CREATE TABLE customer
(
    id    VARCHAR(100) NOT NULL,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    CONSTRAINT email_unique UNIQUE (email),
    PRIMARY KEY (id)
) ENGINE = InnoDB;

DESC customer;

select *
from customer;

CREATE TABLE admin
(
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (username)
) ENGINE = InnoDB;

INSERT INTO admin(username, password)
VALUES ('admin', 'admin');

SELECT *
FROM admin;

CREATE TABLE comments
(
    id      INT NOT NULL AUTO_INCREMENT,
    email   VARCHAR(100),
    comment TEXT,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

SELECT *
FROM comments;

SELECT COUNT(id)
FROM comments;

DELETE
FROM comments;

CREATE TABLE sample_time
(
    id               INT NOT NULL AUTO_INCREMENT,
    sample_date      DATE,
    sample_time      TIME,
    sample_timestamp TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

DESC sample_time;

SELECT * FROM sample_time;