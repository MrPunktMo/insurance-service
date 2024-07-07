# Insurance Service
## _A Mockup_

[Github Link](https://github.com/MrPunktMo/insurance-service)

Insurance-service is a Java Spring based service that represents the main features of a car insurance company: requesting insurance fees for specific car types in different locations.

## Features

- Rest based http(s) communication between the services
- OpenAPI-spec for easy integration in other services and for requesting
- Import a csv file to the database to set the factors per region in relation to postcodes
- Request fees and request all fees a specific user has saved
- Administrator based access to specific features like requesting all saved fees

## Project

The project consists of several sub projects

### Proxy
Currently not finished - proxy uses Spring Cloud as a revers proxy to easily integrate a frontend with session management

### Database
The database project consists of a MySQL-Database-container and a Keycloak container. Keycloak is responsible for the restricted user access.

### Data-Service
The related data(-base) service responsible for fetching the data from the database and the import of the csv-file

### Service
Business logic of the insurance fee calculation. Needs the data-service for the database access.

## Installation

### Database
For running the database containers an environment for running Docker containers is necessary (Docker Desktop on Windows OS for example). In the project is a folder _zipped-data_. This data needs to be unzipped and be packed into a path of your choice. Afterwards a Docker volume needs to be introduced that points to that path with a specific name. The following command can be used to execute that:

```sh
docker volume create insurance_data --opt type=none --opt device=C:/Path/to/insurance/sql/data --opt o=bind
```

DO NOT change the name of the volumen _insurance_data_, the Docker compose file needs EXACTLY this name as it is referring to that volume.

Afterwards use the Docker compose in _service_ to start the containers. Following users are preconfigured:
**Database**
| user | password  |
| ------ | ------ |
| root | password |
| user | password |

**Keycloak**
| user | password  |
| ------ | ------ |
| admin | admin |

**Insurance service**
| user | password  |
| ------ | ------ |
| user | user |
| admin | admin |

### Data-Service
The data service has a ready to go jar-File in the _jar_ folder. The values for the application.yaml are hardcoded but can be overwritten via _environment variables_. After unzipping the service can be started with:
```sh
java -jar insurance-data-service.jar
```

### Insurance-Service
The insurance service has a ready to go jar-File in the _jar_ folder. The values for the application.yaml are hardcoded but can be overwritten via _environment variables_. After unzipping the service can be started with:
```sh
java -jar insurance-service.jar
```

## Usage

**Data service**
Running per default on 
```sh
localhost:8383/insurance_data
```
The exact usage can be seen in the OpenApi-Spec in the insurance-data-service-folder under _insurance-service\insurance-data-service\src\main\resources_.

For the import endpoint the file _postcodes\_preperated.csv_ can be used. This file can be found in the _Challenge_ folder in the main-project. This file was preperated from the _postcode.csv_-file.

**Insurance service**
Running per default on 
```sh
localhost:8181/insurance-service
```
The exact usage can be seen in the OpenApi-Spec in the insurance-data-service-folder under _insurance-service\insurance-service\src\main\resources_.

## License

The Unlicense


