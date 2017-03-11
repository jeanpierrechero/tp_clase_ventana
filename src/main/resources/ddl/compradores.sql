CREATE DATABASE IF NOT EXISTS j2se;
USE j2se;

DROP TABLE IF EXISTS `compradores`;
CREATE TABLE `compradores` (
  `co_id` int(10) unsigned NOT NULL auto_increment,
  `co_nombre` varchar(255) NOT NULL default '',
  `co_apellido` varchar(255) NOT NULL default '',
  `co_documento` varchar(255) NOT NULL default '',
  `co_presupuesto` double NOT NULL default '0',
  PRIMARY KEY  (`co_id`)
);

INSERT INTO `compradores` (`co_id`,`co_nombre`,`co_apellido`,`co_documento`,`co_presupuesto`) VALUES 
 (1,'Hernan','Minetti','24985635',30000),
 (2,'Julian','Arquete','22698536',35000),
 (3,'Manuel','Trumper','24895965',40000),
 (4,'Cecilia','Juliani','27596585',32000);