# Lease API

De **Lease API** is een REST API die het mogelijk maakt de leaseprijs van een auto te berekenen.
Daarbij is het mogelijk om de auto's, klanten en de rentetarieven te beheren.
Voor 

### Het draaien van de applicatie lokaal
De applicatie is opgebouwd uit vier services
- de rate calculator voor het berekenen van het lease tarief
- de car service voor het beheren van de auto's
- de interest service voor het beheren van de rente tarieven
- de customer service voor het beheren van de klanten

#### Bouw de applicatie
Door middel van
```mvn clean install```
kunnen alle onderdelen van de applicatie gebouwd worden.

#### Run application
```./start.sh```
Alle vier de services worden nu gestart
De car service op port 8090
De customer service op port 8091
De interest service op port 8092
De rate calculator op port 8093


#### Test API

##### GET all Cars

curl localhost:8090/cars

###### Create Car
curl -X POST localhost:8090/car/ -H 'Content-type:application/json' -d '{"make": "Volkswagen", "model": "Tiguan", "version": "Ambition", "numberOfDoors": "4", "grossPrice": "38000", "nettPrice": "36000", "horsePower":"150"}'

##### GET Car
Get car 0
curl localhost:8090/cars/0

###### Get Lease Rate
```GET http://localhost:8084/api/lease/leaserate```
Request body example:
```
{
    "carId": 1,
    "contractDuration": 10
}
```

##### GET (Read lease details)
```GET http://localhost:8084/api/lease/<id>```

##### POST (Create new lease)
```POST http://localhost:8084/api/lease```
Request body example:
```
{
    "customerId": 12,
    "carId": 23,
    "startDate": "12-02-2021",
    "endDate": "02-05-2021",
    "interestRate": 3.2
}
```
