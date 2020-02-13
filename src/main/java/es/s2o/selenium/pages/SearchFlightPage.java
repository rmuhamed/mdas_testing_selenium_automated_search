package es.s2o.selenium.pages;

import es.s2o.selenium.domain.SearchFlightCriteriaDto;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class SearchFlightPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // Form
    @FindBy(className = "form-input origin")
    private List<WebElementFacade> origin;
    private WebElementFacade destination;
    private WebElementFacade txtOutboundDate;
    private WebElementFacade txtReturnDate;
    private WebElementFacade txtBabiesNumber;
    private WebElementFacade txtChildrenPassengersNumber;
    private WebElementFacade txtAdultPassengersNumber;

    private WebElementFacade btnSubmitHomeSearcher;
    private WebElementFacade idCookiePolicyCloseOption;

    public void addCriteria(SearchFlightCriteriaDto criteriaDto) {
        LOGGER.debug("search for a flight starts, reservation: [{}]", criteriaDto);

        idCookiePolicyCloseOption.click();
        origin.get(0).click();
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
