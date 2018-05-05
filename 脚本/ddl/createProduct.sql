
DROP TABLE IF EXISTS PRODUCT;

create table PRODUCT (
	ID integer not null auto_increment, 
	NAME varchar(255), 
	PRICE decimal(8,2), 
	PIC varchar(255), 
	REMARK LONGTEXT, 
	REMARK_DETAIL LONGTEXT, 
	PRODUCT_DATE datetime default CURRENT_TIMESTAMP not null, 
	COMMEND bit, 
	OPEN bit, 
	CID integer, 
	primary key (ID)
) engine=MyISAM
