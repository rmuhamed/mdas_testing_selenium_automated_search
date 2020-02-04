package es.s2o.selenium.stepsdefs.reservations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.s2o.selenium.domain.SearchFlightCriteriaDto;
import es.s2o.selenium.pages.SearchPage;
import es.s2o.selenium.services.SearchFlightsService;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sacrists on 26.02.17.
 */
public class SearchFlightsStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String WEB_ROOT = "https://vueling.com/es/";
    private static final String HOME = "reservationList.html";

    @Steps
    private SearchFlightsService searchFlightsService;

    private SearchPage reservationPage;

    private SearchFlightCriteriaDto searchFlightCriteria;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");
        searchFlightsService.addReservations(2);
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario starts");
        searchFlightsService.clean();
    }

    @Given("^I'm in the main page$")
    public void iMInTheMainPage() throws Throwable {
        LOGGER.debug("iMInTheMainPage starts");

        reservationPage.openAt(WEB_ROOT + HOME);
    }

    @When("^I try to find a fly$")
    public void iTryToFindAFly(SearchFlightCriteriaDto searchFlightCriteriaDto) throws Throwable {
        LOGGER.debug("iTryToFindAFly starts", searchFlightCriteriaDto.getOrigin());

        searchFlightCriteria = searchFlightCriteriaDto;
    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() throws Throwable {
        LOGGER.debug("iGetAvailableFlight starts");

        List<SearchFlightCriteriaDto> actualReservations = reservationListPage.getReservationList();
        assertThat(actualReservations).as("Reservation list").usingFieldByFieldElementComparator().containsExactlyElementsOf(reservations);
    }
}
