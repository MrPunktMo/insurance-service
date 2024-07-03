create table insurance_data.region(
    region1 varchar(255) NOT NULL,
	region3 varchar(255) NOT NULL,
    region4 varchar(255) NOT NULL,
    ort varchar(255) NOT NULL,
    postleitzahl varchar(255) NOT NULL,
    PRIMARY KEY(ort, postleitzahl)
);

drop table insurance_data.region;