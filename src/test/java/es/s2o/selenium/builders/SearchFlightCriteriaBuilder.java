package es.s2o.selenium.builders;

import es.s2o.selenium.domain.SearchFlightCriteria;

public class SearchFlightCriteriaBuilder {
    private String origin;
    private String destiny;
    private String departureDate;
    private Integer adultPassengers;
    private Integer childrenPassengers;
    private Integer babiesPassengers;

    private SearchFlightCriteriaBuilder(){}

    public static SearchFlightCriteriaBuilder aSearchCriteria() {
        return new SearchFlightCriteriaBuilder();
    }

    public SearchFlightCriteria build() {
       SearchFlightCriteria someSearchFlightCriteria = new SearchFlightCriteria();
       someSearchFlightCriteria.setOrigin(this.origin);
       someSearchFlightCriteria.setDestiny(this.destiny);
       someSearchFlightCriteria.setDepartureDate(this.departureDate);
       someSearchFlightCriteria.setAdultPassengers(this.adultPassengers);
       someSearchFlightCriteria.setChildrenPassengers(this.childrenPassengers);
       someSearchFlightCriteria.setBabiesPassengers(this.babiesPassengers);

       return someSearchFlightCriteria;
    }

    public SearchFlightCriteriaBuilder withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public SearchFlightCriteriaBuilder withDestiny(String destiny) {
        this.destiny = destiny;
        return this;
    }

    public SearchFlightCriteriaBuilder withDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public SearchFlightCriteriaBuilder withAdultPassengers(Integer adultPassengers) {
        this.adultPassengers = adultPassengers;
        return this;
    }

    public SearchFlightCriteriaBuilder withChildrenPassengers(Integer childrenPassengers) {
        this.childrenPassengers = childrenPassengers;
        return this;
    }

    public SearchFlightCriteriaBuilder withBabiesPassengers(Integer babiesPassengers) {
        this.babiesPassengers = babiesPassengers;
        return this;
    }
}
