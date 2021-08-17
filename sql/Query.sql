show databases;

create database ILSudAfricaTel;

DROP TABLE TelefonoRis;
CREATE TABLE TelefonoRis (
    Id varchar(255) primary key,
    SmsPhone varchar(11),
    Risultato varchar(255)
);

select * from TelefonoRis;
delete from TelefonoRis;