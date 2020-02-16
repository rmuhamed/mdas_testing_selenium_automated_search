package es.salle.rmuhamed.selenium.pages;

import es.salle.rmuhamed.selenium.domain.FlightDTO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class SearchFlightPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "/html/body/div[3]/div[1]/vy-index-search/div/div[2]/div/div[1]/div/form/div[1]/div[1]/div[1]/input")
    private WebElementFacade originElement;
    @FindBy(xpath = "/html/body/div[3]/div[1]/vy-index-search/div/div[2]/div/div[1]/div/form/div[1]/div[2]/div[1]/input")
    private WebElementFacade destinationElement;
    @FindBy(css = "#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(3) > td.ui-datepicker-week-end.ui-datepicker-days-cell-over.ui-datepicker-current-day.ui-datepicker-today")
    private List<WebElement> datePickerElement;
    @FindBy(css = "#passengers-popup > div.passengers-popup_action > button")
    private List<WebElement> passengersButtonElement;
    @FindBy(id = "btnSubmitHomeSearcher")
    private WebElementFacade searchButtonElement;
    @FindBy(id = "idCookiePolicyCloseOption")
    private WebElementFacade cookiesPolicyAcceptanceElement;

    public void addCriteria(FlightDTO dto) {
        LOGGER.debug("Search for a flight starts now ...");

        this.cookiesPolicyAcceptanceElement.click();

        this.originElement.click();
        this.originElement.sendKeys(dto.getOrigin());
        this.originElement.sendKeys(Keys.TAB);

        this.destinationElement.sendKeys(dto.getDestination());
        this.destinationElement.sendKeys(Keys.TAB);

        this.datePickerElement.get(0).click();

        this.passengersButtonElement.get(0).click();

        this.searchButtonElement.click();
    }
}
