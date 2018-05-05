
DROP TABLE IF EXISTS ACCOUNT;

create table ACCOUNT (
	ID integer not null auto_increment, 
	LOGIN varchar(255), 
	NAME varchar(255), 
	PASSWORD varchar(255), 
	primary key (ID)
) engine=MyISAM
