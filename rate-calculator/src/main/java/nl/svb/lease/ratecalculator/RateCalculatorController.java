package nl.svb.lease.ratecalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
public class RateCalculatorController {
    private BigDecimal mileage;
    private BigDecimal duration;
    private BigDecimal nettPrice;
    private BigDecimal interestRate;
    @GetMapping("/calculate/")
    @ResponseBody
    BigDecimal calculate(@RequestParam String mileageUnvalidated, @RequestParam String durationUnvalidated, @RequestParam String nettPriceUnvalidated, @RequestParam String interestRateUnvalidated) {
        validate(mileageUnvalidated, durationUnvalidated, nettPriceUnvalidated, interestRateUnvalidated);
        BigDecimal prijsPerKilometer = mileage.divide(new BigDecimal(12), 2, RoundingMode.DOWN).multiply(duration).divide(nettPrice, 2, RoundingMode.DOWN);
        BigDecimal rentePerMaand = interestRate.divide(new BigDecimal(100), 3, RoundingMode.DOWN).multiply(nettPrice).divide(new BigDecimal(12), 2, RoundingMode.HALF_DOWN);
        return prijsPerKilometer.add(rentePerMaand);
    }

    private void validate(String mileageAsString, String durationInMonth, String nettPriceAsString, String interestRateAsString) {
        mileage = new BigDecimal(mileageAsString);
        assert mileage.compareTo(BigDecimal.ZERO) > 0;
        duration = new BigDecimal(durationInMonth);
        assert duration.compareTo(BigDecimal.ZERO) > 0;
        nettPrice = new BigDecimal(nettPriceAsString);
        assert nettPrice.compareTo(BigDecimal.ZERO) > 0;
        interestRate = new BigDecimal(interestRateAsString);
        assert interestRate.compareTo(BigDecimal.ZERO) > 0;
    }

}
