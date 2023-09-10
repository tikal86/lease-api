package nl.svb.lease.carservice;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import nl.svb.lease.carservice.model.Car;

import java.util.List;

public class WhenCarStage extends Stage<WhenCarStage> {
    @ScenarioState
    public CarController carController;

    @ScenarioState
    public List<Car> foundCars;


    public Stage<WhenCarStage> a_list_is_retrieved() {
        foundCars = carController.all();
        return self();
    }
}
