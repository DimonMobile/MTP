CREATE DATABASE Univer_java_lab2;
USE Univer_java_lab2;
CREATE TABLE User(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(32) NOT NULL UNIQUE,
	password VARCHAR(64) NOT NULL,
	card_num VARCHAR(16),
	card_until DATE,
	card_cvc INT,
	card_sum INT DEFAULT 0);
SHOW COLUMNS FROM User;
INSERT INTO User(name, password, card_num, card_until, card_cvc) VALUES ("Mobile", "ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f", "1234123412341234", 2020-01-20, 123);
SELECT * FROM User;