create table insurance_data.fee(
	fee_id int NOT NULL auto_increment,
    amount float NOT NULL,
    vehicle_type varchar(255) NOT NULL,
    kilometrage integer NOT NULL,
    region varchar(255) NOT NULL,
    created_by varchar(255) NOT NULL,
    created_on DATE NOT NULL,
    PRIMARY KEY(fee_id)
);

drop table insurance_data.fee;