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

    // Form
    @FindBy(css = "#tab-search > div > form > div:nth-child(1) > div.form-input.origin")
    private WebElementFacade origin;

    @FindBy(className = "searchbar-popup cities-sugestion-popup show")
    private WebElementFacade originList;

    @FindBy(xpath = "/html/body/div[3]/div[1]/vy-index-search/div/div[2]/div/div[1]/div/form/div[1]/div[2]/div[1]/input")
    private WebElementFacade destination;
    private WebElementFacade txtOutboundDate;
    private WebElementFacade txtReturnDate;
    private WebElementFacade txtBabiesNumber;
    private WebElementFacade txtChildrenPassengersNumber;
    private WebElementFacade txtAdultPassengersNumber;

    private WebElementFacade btnSubmitHomeSearcher;
    private WebElementFacade idCookiePolicyCloseOption;

    public void addCriteria(FlightDTO flightDTO) {
        LOGGER.debug("search for a flight starts, reservation: [{}]", flightDTO);

        idCookiePolicyCloseOption.click();

        destination.click();
        destination.sendKeys(flightDTO.getDestination());
        destination.sendKeys(Keys.TAB);
//        selectFromDropdown(txtDestination, criteriaDto.getDestination());
//        display.click();
//        typeInto(txtOutboundDate, criteriaDto.getOutbound_date());
//        display.click();
//        typeInto(txtAdultPassengersNumber, criteriaDto.getPassengers());

        btnSubmitHomeSearcher.click();
    }

    private String getHiddenValue(){
        return getDocument().getElementById("hiddenField").attr("value");
    }
}
