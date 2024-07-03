create table insurance_data.factor_kilometrage(
    kilometrage_id int NOT NULL auto_increment,
	kilometre_from integer NOT NULL,
    kilometre_to integer,
    valid_from date NOT NULL,
    valid_to date NOT NULL,
    factor float NOT NULL,
    PRIMARY KEY(kilometrage_id)
);

drop table factor_kilometrage;

create table insurance_data.factor_vehicle_type(
    type_id int NOT NULL auto_increment,
	vehicle_type VARCHAR(255) NOT NULL,
    valid_from date NOT NULL,
    valid_to date NOT NULL,
    factor float NOT NULL,
    PRIMARY KEY(type_id)
);

drop table factor_vehicle_type;

create table insurance_data.factor_region(
    region_id int NOT NULL auto_increment,
	region VARCHAR(255) NOT NULL,
    valid_from date NOT NULL,
    valid_to date NOT NULL,
    factor float NOT NULL,
    PRIMARY KEY(region_id)
);

drop table faktor_region;