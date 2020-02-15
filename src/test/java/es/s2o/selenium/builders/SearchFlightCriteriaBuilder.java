package es.s2o.selenium.builders;

import es.s2o.selenium.domain.SearchFlightCriteria;

public class SearchFlightCriteriaBuilder {
    private String origin;
    private String destination;
    private String outbound_date;
    private Integer passengers;

    private SearchFlightCriteriaBuilder(){}

    public static SearchFlightCriteriaBuilder aSearchCriteria() {
        return new SearchFlightCriteriaBuilder();
    }

    public SearchFlightCriteria build() {
       SearchFlightCriteria someSearchFlightCriteria = new SearchFlightCriteria();
       someSearchFlightCriteria.setOrigin(this.origin);
       someSearchFlightCriteria.setDestination(this.destination);
       someSearchFlightCriteria.setOutboundDate(this.outbound_date);
       someSearchFlightCriteria.setPassengers(this.passengers);

       return someSearchFlightCriteria;
    }

    public SearchFlightCriteriaBuilder withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public SearchFlightCriteriaBuilder withDestination(String destiny) {
        this.destination = destiny;
        return this;
    }

    public SearchFlightCriteriaBuilder withOutboundDate(String departureDate) {
        this.outbound_date = departureDate;
        return this;
    }

    public SearchFlightCriteriaBuilder withPassengers(Integer passengers) {
        this.passengers = passengers;
        return this;
    }
}
