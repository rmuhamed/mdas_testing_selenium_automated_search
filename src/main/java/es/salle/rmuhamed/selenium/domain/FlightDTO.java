package es.salle.rmuhamed.selenium.domain;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
import es.salle.rmuhamed.selenium.converter.ToDayOfMonthConverter;

public class FlightDTO {
    @XStreamAlias("origin")
    private String origin;
    @XStreamAlias("destination")
    private String destination;
    @XStreamAlias("outbound")
    @XStreamConverter(ToDayOfMonthConverter.class)
    private String outboundDate;
    @XStreamAlias("return")
    private String inboundDate;
    @XStreamAlias("passengers")
    private String passengers;

    public FlightDTO() {}

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

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutbound(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInbound(String inboundDate) {
        this.inboundDate = inboundDate;
    }
}
