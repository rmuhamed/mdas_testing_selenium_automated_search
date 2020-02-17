package es.salle.rmuhamed.selenium.builders;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchFlightCriteriaDataBuilder {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DEFAULT_ORIGIN = "BCN";
    public static final String DEFAULT_DESTINATION = "MAD";
    public static final int DEFAULT_ADULT_PASSENGERS = 1;

    public static SearchFlightCriteriaBuilder defaultCriteria() {
        return SearchFlightCriteriaBuilder
                .aSearchCriteria()
                .withOrigin(DEFAULT_ORIGIN)
                .withDestination(DEFAULT_DESTINATION)
                .withOutboundDate(new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTime()))
                .withPassengers(DEFAULT_ADULT_PASSENGERS);
    }

}
