package es.s2o.selenium.domain;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;

public class SearchFlightCriteriaDto {
    private String origin;
    private String destiny;
    private String date;
    private String adults;
    private String childrens;
    private String babies;

    @XStreamConverter(TableColorConverter.class)
    private String color;

    public SearchFlightCriteriaDto() {}

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildrens() {
        return childrens;
    }

    public void setChildrens(String childrens) {
        this.childrens = childrens;
    }

    public String getBabies() {
        return babies;
    }

    public void setBabies(String babies) {
        this.babies = babies;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
