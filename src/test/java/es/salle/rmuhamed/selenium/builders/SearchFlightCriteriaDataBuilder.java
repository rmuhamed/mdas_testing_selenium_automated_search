package es.salle.rmuhamed.selenium.builders;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchFlightCriteriaDataBuilder {
    public static SearchFlightCriteriaBuilder defaultCriteria() {
        return SearchFlightCriteriaBuilder
                .aSearchCriteria()
                .withOrigin("BCN")
                .withDestination("MAD")
                .withOutboundDate(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()))
                .withPassengers(1);
    }

}