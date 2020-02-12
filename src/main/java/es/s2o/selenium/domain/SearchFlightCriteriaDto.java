package es.s2o.selenium.domain;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;

public class SearchFlightCriteriaDto {
    private String origin;
    private String destination;
    private String outbound_date;
    private String return_date;
    private String passengers;

    public SearchFlightCriteriaDto() {}

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOutbound_date() {
        return outbound_date;
    }

    public void setOutbound_date(String outbound_date) {
        this.outbound_date = outbound_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }
}
