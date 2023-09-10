package nl.svb.lease.carservice;

import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.junit5.JGivenExtension;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// TODO test other methods
@ExtendWith( JGivenExtension.class )
class CarControllerTest extends ScenarioTest<GivenCarStage, WhenCarStage, ThenCarStage> {
    @ScenarioStage
    GivenCarStage givenStage;

    @ScenarioStage
    WhenCarStage whenStage;

    @ScenarioStage
    ThenCarStage thenStage;
    @Test
    public void all() {
        givenStage.given().
                a_list_of_cars();
        whenStage.when().
                a_list_is_retrieved();
        thenStage.then().
                a_list_of_two_cars_should_be_found();


    }
}