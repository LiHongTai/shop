
DROP TABLE IF EXISTS CATEGORY;

create table CATEGORY (
	ID integer not null auto_increment, 
	TYPE varchar(255), 
	HOT bit, 
	CID integer, 
	primary key (ID)
) engine=MyISAM
