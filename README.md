# Lease API

De **Lease API** is een REST API die het mogelijk maakt de leaseprijs van een auto te berekenen.
Daarbij is het mogelijk om de auto's, klanten en de rentetarieven te beheren.

## Het draaien van de applicatie lokaal
De applicatie is opgebouwd uit vier services
- de rate calculator voor het berekenen van het lease tarief
- de car service voor het beheren van de auto's
- de interest service voor het beheren van de rente tarieven
- de customer service voor het beheren van de klanten

### Bouw de applicatie
Door middel van
```mvn clean install```
kunnen alle onderdelen van de applicatie gebouwd worden.

### Draai de applicatie
Door het draaien van het linux batch bestand
```./start.sh```
Worden alle vier de services gestart

De car service op port 8090

De customer service op port 8091

De interest service op port 8092

De rate calculator op port 8093

De service kunnen ook apart gestart worden door naar de respectievelijke service te gaan en deze te starten

cd car-service
mvn spring-boot:run

cd customer-service
mvn spring-boot:run

cd interest-service
mvn spring-boot:run

cd rate-calculator
mvn spring-boot:run


### Test de API

#### Beheren van de auto's
##### Haal alle auto's op
curl localhost:8090/cars

##### Maak een auto
curl -X POST localhost:8090/car/ -H 'Content-type:application/json' -d '{"make": "Volkswagen", "model": "Tiguan", "version": "Ambition", "numberOfDoors": "4", "grossPrice": "38000", "nettPrice": "36000", "horsePower":"150"}'

##### Haal de eerste auto op
curl localhost:8090/cars/0

##### Bereken de leaserate
Doe een get op http://localhost:8093/leaserate
Met de verplichte parameters
- mileage, het aantal kilometers
- duration, de looptijd in maanden
- nettPrice, de netto prijs van de auto
- interestRate, het rente tarief 
Voorbeeld
curl 'localhost:8093/api/calculate?mileage=63000&duration=60&nettPrice=36000&interestRate=4.5'

#### Beheren van de klanten
Dit moet nog geimplementeerd worden

#### Beheren van de rente tarieven
Dit moet nog geimplementeerd worden