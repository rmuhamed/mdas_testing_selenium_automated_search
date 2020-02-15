package es.s2o.selenium.pages;

import es.s2o.selenium.domain.FlightDTO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SearchFlightPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "/html/body/div[3]/div[1]/vy-index-search/div/div[2]/div/div[1]/div/form/div[1]/div[1]/div[1]/input")
    private WebElementFacade origin;
    @FindBy(xpath = "/html/body/div[3]/div[1]/vy-index-search/div/div[2]/div/div[1]/div/form/div[1]/div[2]/div[1]/input")
    private WebElementFacade destination;
    @FindBy(id = "btnSubmitHomeSearcher")
    private WebElementFacade searchButtonElement;
    @FindBy(id = "idCookiePolicyCloseOption")
    private WebElementFacade cookiesPolicyAcceptanceElement;

    public void addCriteria(FlightDTO dto) {
        LOGGER.debug("search for a flight starts");

        this.cookiesPolicyAcceptanceElement.click();

        this.origin.click();
        this.origin.sendKeys(dto.getOrigin());
        this.origin.sendKeys(Keys.TAB);

        this.destination.sendKeys(dto.getDestination());
        this.destination.sendKeys(Keys.TAB);

        this.searchButtonElement.click();
    }
}
