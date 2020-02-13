package es.s2o.selenium.stepsdefs.searchflights;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.s2o.selenium.domain.SearchFlightCriteriaDto;
import es.s2o.selenium.pages.SearchFlightPage;
import es.s2o.selenium.services.SearchFlightsService;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class SearchFlightsStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String WEB_ROOT = "https://vueling.com/es/";
    private static final String HOME = "reservationList.html";

    @Steps
    private SearchFlightsService searchFlightsService;

    private SearchFlightPage searchFlightPage;

    private List<SearchFlightCriteriaDto> searchFlightCriteria;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");
        this.searchFlightsService.addSearchFlightCriteria();
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario starts");
        this.searchFlightsService.clean();
    }

    @Given("^I'm in the main page$")
    public void iMInTheMainPage() throws Throwable {
        LOGGER.debug("iMInTheMainPage starts");

        this.searchFlightPage.openAt(WEB_ROOT);
    }

    @When("^I try to find a flight$")
    public void iTryToFindAFlight(List<SearchFlightCriteriaDto> searchFlightCriteriaDto) throws Throwable {
        LOGGER.debug("iTryToFindAFlight starts");

        this.searchFlightCriteria = searchFlightCriteriaDto;

        this.searchFlightPage.addCriteria(this.searchFlightCriteria.get(0));
    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() throws Throwable {
        LOGGER.debug("iGetAvailableFlight starts");
    }
}
