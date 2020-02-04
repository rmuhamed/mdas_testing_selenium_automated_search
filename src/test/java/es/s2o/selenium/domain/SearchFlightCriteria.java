package es.s2o.selenium.domain;

public class SearchFlightCriteria {
    private String origin;
    private String destiny;
    private String departureDate;
    private Integer adultPassengers;
    private Integer childrenPassengers;
    private Integer babiesPassengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getAdultPassengers() {
        return adultPassengers;
    }

    public void setAdultPassengers(Integer adultPassengers) {
        this.adultPassengers = adultPassengers;
    }

    public Integer getChildrenPassengers() {
        return childrenPassengers;
    }

    public void setChildrenPassengers(Integer childrenPassengers) {
        this.childrenPassengers = childrenPassengers;
    }

    public Integer getBabiesPassengers() {
        return babiesPassengers;
    }

    public void setBabiesPassengers(Integer babiesPassengers) {
        this.babiesPassengers = babiesPassengers;
    }
}
