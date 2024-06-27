create table insurance_data.Person(
    PersonID int NOT NULL auto_increment,
	lastname varchar(255) NOT NULL,
    firstname varchar(255) NOT NULL,
    birthday date NOT NULL,
    street varchar(255),
    houseNo varchar(10),
    city varchar(255),
    PRIMARY KEY(PersonID)
);

insert into insurance_data.Person(lastname, firstname, birthday)
values ('Mustermann','Max', '2007-10-09');

select * from person;