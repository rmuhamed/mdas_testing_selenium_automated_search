package es.salle.rmuhamed.selenium.pages;

import es.salle.rmuhamed.selenium.domain.FlightDTO;
import es.salle.rmuhamed.selenium.pages.utils.HtmlTableWrapper;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.By;
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
    @FindBy(className = "ui-datepicker-calendar")
    private WebElement datePickerElement;
    @FindBy(css = "#passengers-popup > div.passengers-popup_action > button")
    private List<WebElement> passengersButtonElement;
    @FindBy(id = "btnSubmitHomeSearcher")
    private WebElementFacade searchButtonElement;
    @FindBy(id = "idCookiePolicyCloseOption")
    private WebElementFacade cookiesPolicyAcceptanceElement;

    public void addCriteria(FlightDTO dto) {
        LOGGER.debug("Search for a flight starts now ...");
        //Accept cookies policy first
        this.cookiesPolicyAcceptanceElement.click();
        //Then select the desired origin
        this.originElement.click();
        this.originElement.sendKeys(dto.getOrigin());
        this.originElement.sendKeys(Keys.TAB);
        //Same but for destination
        this.destinationElement.sendKeys(dto.getDestination());
        this.destinationElement.sendKeys(Keys.TAB);
        //Selected the wanted date inside Date picker
        WebElement outboundDayElement = HtmlTableWrapper.from(HtmlTable.inTable(this.datePickerElement))
                .allTheRowsWithoutHeading()
                .toFlattenColumns()
                .findCellBy(dto.getOutboundDate());
        //Once We have that day, just click it
        outboundDayElement.click();
        //Wanted one passenger, so just click to accept the default number, i.e 1
        this.passengersButtonElement.get(0).click();
        //Finally, click "Search" button to fire the search engine following the above defined criteria
        this.searchButtonElement.click();
    }
}
