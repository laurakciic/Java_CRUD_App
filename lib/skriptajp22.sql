# ljestve (hash) na početku linije je komentar
# c:\xampp\mysql\bin\mysql -uedunova -pedunova --default_character_set=utf8mb4 < C:\jp22\eclipse-workspace\Edunova10\skriptajp22.sql
drop database if exists edunovajp22;
create database edunovajp22 character set utf8mb4;
use edunovajp22;

create table smjer(
    sifra       int not null primary key auto_increment,
    naziv       varchar(50) not null,
    opis        text,
    cijena      decimal(18,2),
    verificiran boolean,
    nadreden int
);

create table grupa(
    sifra int not null primary key auto_increment,
    naziv varchar(50) not null,
    smjer int not null,
    predavac int,
    datumpocetka datetime
);

create table predavac(
    sifra int not null primary key auto_increment,
    osoba int not null,
    iban varchar(50)
);

create table polaznik(
    sifra int not null primary key auto_increment,
    osoba int not null,
    brojugovora varchar(50)
);

create table osoba(
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    oib char(11),
    email varchar(100) not null
);

create table clan(
    grupa int not null,
    polaznik int not null
);

alter table grupa add foreign key (smjer) references smjer(sifra);
alter table grupa add foreign key (predavac) references predavac(sifra);

alter table predavac add foreign key (osoba) references osoba(sifra);

alter table polaznik add foreign key (osoba) references osoba(sifra);

alter table clan add foreign key (grupa) references grupa(sifra);
alter table clan add foreign key (polaznik) references polaznik(sifra);

alter table smjer add foreign key (nadreden) references smjer(sifra);



#show tables;

#describe smjer;
# select * from smjer;

# najlošija
# 1 - to će biti dodjeljena šifra
insert into smjer values 
(null, 'Java programiranje', null, null, null, null);

# bolja 
# 2
insert into smjer (naziv) 
values ('PHP programiranje');

# primjer dobre prakse
# 3
insert into smjer(naziv, cijena, verificiran)
values ('Web dizajner', 4999.99, true);

# 4
insert into smjer(sifra, naziv, opis, cijena, verificiran, nadreden)
values (null, 'Serviser', null, null, null, null);

# 5
insert into smjer(naziv, nadreden)
values('OOP', 1);

# 1 - 20
# select * from osoba;
insert into osoba(prezime, ime, email, oib)
values
('Jakopec', 'Tomislav', 'tjakopec@gmail.com', null),
('Balić','Dolores','dolores.balic@gmail.com',null),
('Brezić','Rafael','brezicrafael10@gmail.com',null),
('Cuca','Luka','lukacuca@gmail.com',null),
('Danković','Marko','marko.dankovic2541@gmail.com',null),
('Dorić','Dominik','dominikdoric277@gmail.com',null),
('Drezgić','Bojan','nesquick7777@gmail.com',null),
('Friščić','Bernard','bernard.friscic@gmail.com',null),
('Horvat','Josip','josiph988@gmail.com',null),
('Jahaj','Bljeona','jahajbljeona@gmail.com',null),
('Jović','Mateo','mateo.jovic@student.ferit.hr',null),
('Kovačić','Laura','laurakciic@gmail.com',null),
('Mikulić','Matej','mmatejos@gmail.com',null),
('Milišić','Laura','laura.milisic@outlook.com',null),
('Pejić','Željko','zeljkopejic@yahoo.com',null),
('Raguž','Matej','mraguz28@gmail.com',null),
('Škrbina','Hrvoje','hrvojesmsskrbina@gmail.com',null),
('Vidanec','Ivan','ividanec@gmail.com',null),
('Vuko','Marin','vuko.marin52@gmail.com',null),
('Predmerski','Boris','bpredmerski@gmail.com',null);

# Shaquille O'Neal
# 21
insert into osoba(ime, prezime, email)
values('Shaquille',"O'Neal", 'saki@gmail.com'),
('Shaquille','O\'Neal','saki@gmail.com'),
('Shaquille','O''Neal','saki@gmail.com');

# 1 - 2
insert into predavac(osoba, iban)
values (1, 'HR5623600003585683611'),
('21', 'HR3424020066638981668');

# select * from predavac;
# 1 - 19
insert into polaznik (osoba)
select sifra from osoba
where sifra not in (1,21,22,23);

# select * from polaznik;
# 1 - 2
insert into grupa(naziv, smjer, predavac)
values('JP22', 1,1),
('PP21', 2,2);

# select * from grupa;

insert into clan(grupa,polaznik)
select 1,sifra from polaznik;

insert into clan(grupa,polaznik)
select 2,sifra from polaznik where sifra <=10;


