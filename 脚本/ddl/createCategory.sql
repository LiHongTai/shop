
DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(255) DEFAULT NULL,
  `HOT` bit(1) DEFAULT NULL,
  `AID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKqdgd7c9hke9yjsehskwfgtw6c` (`aid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;