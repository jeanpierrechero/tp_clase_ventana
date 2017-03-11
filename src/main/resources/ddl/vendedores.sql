CREATE DATABASE IF NOT EXISTS j2se;
USE j2se;

DROP TABLE IF EXISTS `vendedores`;
CREATE TABLE `vendedores` (
  `ve_id` int(10) unsigned NOT NULL auto_increment,
  `ve_nombre` varchar(225) NOT NULL default '',
  `ve_apellido` varchar(255) NOT NULL default '',
  `ve_documento` varchar(255) NOT NULL default '',
  `ve_cant_autos_vendidos` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`ve_id`)
);

INSERT INTO `vendedores` (`ve_id`,`ve_nombre`,`ve_apellido`,`ve_documento`,`ve_cant_autos_vendidos`) VALUES 
 (1,'Juan','Polira','25896524',5),
 (2,'Mariano','Perez','26898741',12),
 (3,'Leonardo','Lopez','22365965',15),
 (4,'Ernesto','Bioti','18965352',38);