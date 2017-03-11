CREATE DATABASE j2se;
USE j2se;

DROP TABLE IF EXISTS `autos`;
CREATE TABLE `autos` (
  `au_id` int(10) unsigned NOT NULL auto_increment,
  `au_marca` varchar(255) NOT NULL default '',
  `au_modelo` varchar(255) NOT NULL default '',
  `au_precio` float NOT NULL default '0',
  `au_color` varchar(255) NOT NULL default '',
  `au_largo` int(10) unsigned NOT NULL default '0',
  `au_ancho` int(10) unsigned NOT NULL default '0',
  `au_altura` int(10) unsigned NOT NULL default '0',
  `au_equipamiento` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`au_id`)
);

INSERT INTO `autos` (`au_id`,`au_marca`,`au_modelo`,`au_precio`,`au_color`,`au_largo`,`au_ancho`,`au_altura`, `au_equipamiento`) VALUES 
 (1,'Peugeot','2003',20000,'Rojo',250,197,90, 'bla bla bla'),
 (2,'Volkswagen','2004',15000,'Negro',248,193,87, 'bla bla bla'),
 (3,'Chevrolet','1998',25000,'Blanco',244,200,89, 'bla bla bla'),
 (4,'Peugeot','1999',18000,'Verde',258,198,88, 'bla bla bla'),
 (5,'Citroen','2002',18000,'Gris',256,199,88, 'bla bla bla');