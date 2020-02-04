package es.s2o.selenium.pages;

import es.s2o.selenium.domain.SearchFlightCriteriaDto;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SearchPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // Form
    private WebElementFacade txtOrigin;
    private WebElementFacade txtDestiny;
    private WebElementFacade txtDate;
    private WebElementFacade txtBabiesNumber;
    private WebElementFacade txtChildrenPassengersNumber;
    private WebElementFacade txtAdultPassengersNumber;

    private WebElementFacade btnSave;
    private WebElementFacade display;

    public void searchForAFlight(SearchFlightCriteriaDto criteriaDto) {
        LOGGER.debug("search for a flight starts, reservation: [{}]", criteriaDto);

        display.click();
        typeInto(txtOrigin, criteriaDto.getOrigin());
        display.click();
        typeInto(txtDestiny, criteriaDto.getDestiny());
        display.click();
        typeInto(txtDate, criteriaDto.getDate());
        display.click();
        typeInto(txtAdultPassengersNumber, criteriaDto.getAdults());

        btnSave.click();
    }

    private String getHiddenValue(){
        return getDocument().getElementById("hiddenField").attr("value");
    }
}
