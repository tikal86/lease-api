package nl.svb.lease.carservice;

import nl.svb.lease.carservice.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {
    private final List<Car> cars = new ArrayList<>();

    @GetMapping("/cars")
    List<Car> all() {
        return cars;
    }

    @PostMapping("/car")
    Car newCar(@RequestBody Car newCar) {
        cars.add(newCar);
        return newCar;
    }

    @GetMapping("/cars/{id}")
    Car one(@PathVariable Long id) {
        return cars
                .stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException(id));
    }

}
