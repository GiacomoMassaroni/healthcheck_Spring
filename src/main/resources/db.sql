CREATE SCHEMA healthcare;
use healthcare;

CREATE TABLE user(
id INT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(30) NOT NULL UNIQUE,
password VARCHAR(20) NOT NULL,
usertype INT DEFAULT 2
);

INSERT INTO user VALUES (1, "super", "super",0), (2, "admin", "admin",1),(3,"user","user",2);

CREATE TABLE registry(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL,
birthDate VARCHAR(10) NOT NULL,
gender INT NOT NULL,
nationality VARCHAR(2) NOT NULL,
city VARCHAR(30) NOT NULL,
address VARCHAR(30) NOT NULL,
cf VARCHAR(16) NOT NULL UNIQUE,
bg VARCHAR(3) NOT NULL,
idUser INT NOT NULL,
FOREIGN KEY (idUser) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE bloodTest(
id INT PRIMARY KEY AUTO_INCREMENT,
redBloodCell FLOAT,
whiteBLoodCell FLOAT,
platelets FLOAT,
hemoglobin FLOAT,
idAdmin INT,
idUser INT NOT NULL,
isChecked BOOLEAN DEFAULT false,
dateInsert VARCHAR(10) NOT NULL,
FOREIGN KEY (idUser) REFERENCES user(id) ON DELETE CASCADE,
FOREIGN KEY (idAdmin) REFERENCES user(id) ON DELETE SET NULL
);

CREATE TABLE urineTest(
id INT PRIMARY KEY AUTO_INCREMENT,
color FLOAT,
ph FLOAT,
protein FLOAT,
hemoglobin FLOAT,
idAdmin INT,
idUser INT NOT NULL,
isChecked BOOLEAN DEFAULT false,
dateInsert VARCHAR(10) NOT NULL,
FOREIGN KEY (idUser) REFERENCES user(id) ON DELETE CASCADE,
FOREIGN KEY (idAdmin) REFERENCES user(id) ON DELETE SET NULL
); 

INSERT INTO user 
VALUES (4,'u.fiorillo@contrader.it','ubaldo',2),
(5,'v.divita@contrader.it','vincenzo',2),
(6,'l.cennamo@contrader.it','lorenzo',2),
(7,'f.miceli@contrader.it','fabio',2),
(8,'e.inchingolo@contrader.it','enrico',2),
(9,'g.massaroni@contrader.it','giacomo',2);

INSERT INTO registry 
VALUES (1,'super','super','1995-07-23',0,'BG','Bruxells','Via dei fiori 15','LRZSCH97IT85V8C1','0+',1),
(2,'admin','admin','1995-07-23',0,'RU','Mosca','Via delle mosche 2','GCMDRV789IT156LM','0+',2),
(3,'user','user','1995-07-23',0,'IT','Padova','Via delle patate 178','FBCRLC431IT852MV','0+',3),
(4,'ubaldo','alonso','1995-07-23',0,'SP','Valencia','Cale colon 154A','BLDLNS367SP256FG','0+',4),
(5,'vincenzo','di vita','1995-07-23',0,'IT','Catania','Via delle arancine 4','VNCNZVT789IT1976','0+',5),
(6,'lorenzo','schillacci','1995-07-23',0,'FR','Parigi','Via delle baguette 15','LRZSCH97IT85VC61','0+',6),
(7,'fabio','zerocalcare','1995-07-23',0,'IT','Roma','Via delle marie 178','FBCLCR431IT852MV','0+',7),
(8,'enrico','inchingolo','1995-07-23',0,'IT','Andria','Via bologna 13','NRCNCH95H0IT05A0','0+',8),
(9,'giacomo','verdi','1995-07-23',0,'IT','MILANO','Via delle rose 2','GCMVRD789IT156LM','0+',9);

INSERT INTO urinetest 
VALUES (1,11,58,32,325,2,4,false,"2024-01-05"),
(2,59,25,69,1789,2,4,false,"2024-02-05"),
(3,346,350,74,957,2,4,false,"2024-03-05"),
(4,16,57,37,326,2,5,false,"2024-04-05"),
(5,59,25,69,1789,2,5,false,"2024-05-05"),
(6,346,350,74,957,2,5,false,"2024-06-05"),
(7,51,167,254,1346,2,6,false,"2024-07-05"),
(8,76,76,24,5276,2,6,false,"2024-08-05"),
(9,145,49,167,1679,2,6,false,"2024-02-05"),
(10,16,57,37,326,2,7,false,"2024-01-05"),
(11,59,25,69,1789,2,7,false,"2024-03-05"),
(12,346,350,74,957,2,8,false,"2024-03-05"),
(13,51,167,254,1346,2,8,false,"2024-04-05"),
(14,76,76,24,5276,2,9,false,"2024-07-05"),
(15,145,49,167,1679,2,9,false,"2024-07-05");
INSERT INTO bloodtest 
VALUES
(1,11,58,32,325,2,4,false,"2024-08-05"),
(2,59,25,69,1789,2,4,false,"2024-08-05"),
(3,346,350,74,57,2,5,false,"2024-07-05"),
(4,16,57,37,326,2,5,false,"2024-06-05"),
(5,59,25,69,1789,2,6,false,"2024-06-05"),
(6,346,350,74,957,2,6,false,"2024-07-05"),
(7,51,167,254,1346,2,7,false,"2024-05-05"),
(8,76,76,24,5276,2,7,false,"2024-01-05"),
(9,145,49,167,167,2,7,false,"2024-01-05"),
(10,16,57,37,326,2,8,false,"2024-01-05"),
(11,59,25,69,1789,2,8,false,"2024-02-05"),
(12,346,350,74,957,2,8,false,"2024-03-05"),
(13,51,167,254,1346,2,9,false,"2024-01-05"),
(14,76,76,24,5276,2,9,false,"2024-05-05"),
(15,145,49,167,1679,2,9,false,"2024-01-05");