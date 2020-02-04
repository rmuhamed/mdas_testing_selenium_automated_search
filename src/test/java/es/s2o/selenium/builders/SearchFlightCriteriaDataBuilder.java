package es.s2o.selenium.builders;

import es.s2o.selenium.domain.SearchFlightCriteria;

import java.util.Calendar;
import java.util.Date;

public class SearchFlightCriteriaDataBuilder {
    public static SearchFlightCriteriaBuilder defaultCriteria() {
        return SearchFlightCriteriaBuilder
                .aSearchCriteria()
                .withOrigin("Barcelona")
                .withDestiny("Alicante")
                .withDepartureDate("04/02/2020")
                .withAdultPassengers(1)
                .withChildrenPassengers(1)
                .withBabiesPassengers(0);
    }

}
