DROP TABLE IF EXISTS Sporter;
DROP TABLE IF EXISTS Locatie;

CREATE TABLE Locatie(
    adresNr INT NOT NULL AUTO_INCREMENT,
    postcode VARCHAR(6),
    huisnummer INT,
    straatnaam VARCHAR (100),
    PRIMARY KEY (adresNr)
    );

CREATE TABLE Sporter(
    SporterId INT NOT NULL AUTO_INCREMENT,
    naam VARCHAR(100),
    DateOfBirth DATE,
    achternaam VARCHAR(100),
    email VARCHAR(100),
    wachtwoord VARCHAR(255),
    Locatie_adresNr INT,
    PRIMARY KEY (SporterId),
    FOREIGN KEY (Locatie_adresNr) REFERENCES Locatie(adresNr)
    );

INSERT INTO Locatie VALUES (1, '6828XX', 17, 'Spoorwegstraat');
INSERT INTO Locatie VALUES (2, '6942OS', 69, 'testerseweg');

INSERT INTO Sporter values (1, 'martijn', '1996-12-28', 'hogendoorn', 'martijn@gmail.com', 'mrtijn', 1);
INSERT INTO Sporter values (2, 'tester', '1970-01-01', 'test', 'testertest@gmail.com', 'test', 1);