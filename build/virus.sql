CREATE SCHEMA virus;
CREATE TABLE virus.chinatotal (
	id INT NOT NULL AUTO_INCREMENT,
	confirm varchar(100) NULL,
	heal varchar(100) NULL,
	dead varchar(100) NULL,
	nowconfirm varchar(100) NULL,
	suspect varchar(100) NULL,
	nowsevere varchar(100) NULL,
	importedcase varchar(100) NULL,
	noinfect varchar(100) NULL,
	showlocalconfirm varchar(100) NULL,
	showlocalinfeciton varchar(100) NULL,
	localconfirm varchar(100) NULL,
	noinfecth5 varchar(100) NULL,
	localconfirmh5 varchar(100) NULL,
	lastupdatetime varchar(100) NULL,
	CONSTRAINT chinatotal_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE virus.areatree (
	id INT NOT NULL AUTO_INCREMENT,
	name varchar(100) NULL,
	count_confirm varchar(100) NULL,
	count_confirmcuts varchar(100) NULL,
	count_wzz_add varchar(100) NULL,
	confirm varchar(100) NULL,
	dead varchar(100) NULL,
	heal varchar(100) NULL,
	wzz varchar(100) NULL,
	suspect varchar(100) NULL,
	nowconfirm varchar(100) NULL,
	showheal varchar(100) NULL,
	showrate varchar(100) NULL,
	lastupdatetime varchar(100) NULL,
	CONSTRAINT areatree_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;