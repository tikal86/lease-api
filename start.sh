#!/bin/bash
cd car-service
mvn spring-boot:run &
cd ..

cd customer-service
mvn spring-boot:run &
cd ..

cd interest-service
mvn spring-boot:run &
cd ..

cd rate-calculator
mvn spring-boot:run &
cd ..
