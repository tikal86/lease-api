package nl.svb.lease.ratecalculator;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Leaserate = ((( mileage / 12 ) * duration ) / Nett price) + ((( Interest rate / 100 ) * Nett price) / 12 )
 * Mileage, the amount of kilometers on annual base
 * Duration of the contract in months
 * Interest rate w/ startdate
 * Nett price of the car
 */
// TDDO Error handling
@RestController
@RequestMapping("/api")
public class RateCalculatorController {
    private BigDecimal validMileage;
    private BigDecimal validDuration;
    private BigDecimal validNettPrice;
    private BigDecimal validInterestRate;
    @GetMapping("/leaserate")
    @ResponseBody
    BigDecimal calculate(@RequestParam String mileage, @RequestParam String duration, @RequestParam String nettPrice, @RequestParam String interestRate) {
        validate(mileage, duration, nettPrice, interestRate);
        BigDecimal prijsPerKilometer = validMileage.divide(new BigDecimal(12), 2, RoundingMode.DOWN).multiply(validDuration).divide(validNettPrice, 2, RoundingMode.DOWN);
        BigDecimal rentePerMaand = validInterestRate.divide(new BigDecimal(100), 3, RoundingMode.DOWN).multiply(validNettPrice).divide(new BigDecimal(12), 2, RoundingMode.HALF_DOWN);
        return prijsPerKilometer.add(rentePerMaand);
    }

    private void validate(String mileageAsString, String durationInMonth, String nettPriceAsString, String interestRateAsString) {
        validMileage = new BigDecimal(mileageAsString);
        assert validMileage.compareTo(BigDecimal.ZERO) > 0;
        validDuration = new BigDecimal(durationInMonth);
        assert validDuration.compareTo(BigDecimal.ZERO) > 0;
        validNettPrice = new BigDecimal(nettPriceAsString);
        assert validNettPrice.compareTo(BigDecimal.ZERO) > 0;
        validInterestRate = new BigDecimal(interestRateAsString);
        assert validInterestRate.compareTo(BigDecimal.ZERO) > 0;
    }

}
