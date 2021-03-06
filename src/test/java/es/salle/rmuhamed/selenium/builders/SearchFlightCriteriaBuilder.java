package es.salle.rmuhamed.selenium.builders;

import es.salle.rmuhamed.selenium.domain.SearchFlightCriteria;

public class SearchFlightCriteriaBuilder {
    private String origin;
    private String destination;
    private String outboundDate;
    private Integer passengers;

    private SearchFlightCriteriaBuilder(){}

    public static SearchFlightCriteriaBuilder aSearchCriteria() {
        return new SearchFlightCriteriaBuilder();
    }

    public SearchFlightCriteria build() {
       SearchFlightCriteria someSearchFlightCriteria = new SearchFlightCriteria();
       someSearchFlightCriteria.setOrigin(this.origin);
       someSearchFlightCriteria.setDestination(this.destination);
       someSearchFlightCriteria.setOutboundDate(this.outboundDate);
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

    public SearchFlightCriteriaBuilder withOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
        return this;
    }

    public SearchFlightCriteriaBuilder withPassengers(Integer passengers) {
        this.passengers = passengers;
        return this;
    }
}
