package es.salle.rmuhamed.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static net.thucydides.core.pages.components.HtmlTable.inTable;

public class FlightListPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "availabilityTable0")
    private WebElement availableFlightsElement;

    @FindBy(id = "marketOption")
    private List<WebElement> availableFlightRowsElement;

    public Integer getNumberOfAvailableFlights() {
        LOGGER.debug("Showing flights available starts here ...");

        HtmlTable flightTable = inTable(this.availableFlightsElement);

        if (flightTable.getHeadings().isEmpty()) {
            return 0;
        }

        if (this.availableFlightRowsElement == null) {
            return null;
        }

        return this.availableFlightRowsElement.size();
    }

}
