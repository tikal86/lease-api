package nl.svb.lease.carservice;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.base.StageBase;
import nl.svb.lease.carservice.model.Car;

public class GivenCarStage extends Stage<GivenCarStage> {

    @ScenarioState
    public CarController carController;

    public StageBase<GivenCarStage> a_list_of_cars() {
        carController = new CarController();
        Car lexus = new Car("Lexus", "IS220d", "Sport", 4, "44285", "28488,66", 177);
        carController.newCar(lexus);
        Car renault = new Car("Renault", "master", "L2H1 T35 dCi 135 EU6 FWD", 2, "48739,98", "30540", 135);
        carController.newCar(renault);
        return self();
    }
}
