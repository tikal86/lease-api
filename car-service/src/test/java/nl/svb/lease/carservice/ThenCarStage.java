package nl.svb.lease.carservice;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import nl.svb.lease.carservice.model.Car;
import org.assertj.core.api.Assertions;

import java.util.List;

public class ThenCarStage extends Stage<ThenCarStage> {
    @ScenarioState(required = true)
    public List<Car> foundCars;

    public Stage<ThenCarStage> a_list_of_two_cars_should_be_found() {
        Assertions.assertThat(foundCars).hasSize(2);
        return self();
    }
}
