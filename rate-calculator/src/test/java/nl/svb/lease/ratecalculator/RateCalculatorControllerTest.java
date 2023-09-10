package nl.svb.lease.ratecalculator;

import com.tngtech.jgiven.junit5.SimpleScenarioTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;


public class RateCalculatorControllerTest extends SimpleScenarioTest<RateCalculatorControllerTest.Steps> {

    @ParameterizedTest
    @MethodSource("data")
    void calculate(
            final String mileage,
            final String duration,
            final String nettPrice,
            final String interestRate,
            final String expectedLeaseRate
    ) {
        given()
                .valid_mileage_duration_nett_price_and_interest_rate(mileage, duration, nettPrice, interestRate);
        when()
                .lease_rate_is_calculated();
        then()
                .the_lease_rate_is(expectedLeaseRate);
    }
    private static Stream<Arguments> data() {
        // mileage, duration, nett price, interest rate, expected lease rate
        return Stream.of(
                Arguments.of("45000", "60", "63000", "4.5" , "239.82")
        );
    }

    public static class Steps {
        private String mileage;
        private String duration;
        private String nettPrice;
        private String interestRate;
        private BigDecimal calculatedLeaseRate;

        private final RateCalculatorController rateCalculatorController = new RateCalculatorController();

        public void valid_mileage_duration_nett_price_and_interest_rate(String mileage, String duration, String nettPrice, String interestRate) {
            this.mileage = mileage;
            this.duration = duration;
            this.nettPrice = nettPrice;
            this.interestRate = interestRate;
        }

        public void lease_rate_is_calculated() {
            calculatedLeaseRate = rateCalculatorController.calculate(mileage, duration, nettPrice, interestRate);
        }

        public void the_lease_rate_is(String expectedLeaseRate) {
            Assertions.assertThat(calculatedLeaseRate).isEqualTo(new BigDecimal(expectedLeaseRate));
        }
    }
}