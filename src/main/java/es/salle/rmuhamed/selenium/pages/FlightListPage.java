package es.salle.rmuhamed.selenium.pages;

import es.salle.rmuhamed.selenium.domain.FlightDTO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class FlightListPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "availabilitySection")
    private WebElement availableFlights;

    public List<FlightDTO> getFlights() {
        LOGGER.debug("getReservationList starts");

        return null;
    }

}
