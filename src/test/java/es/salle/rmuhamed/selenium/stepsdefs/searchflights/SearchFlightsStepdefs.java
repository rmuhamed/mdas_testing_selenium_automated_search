package es.salle.rmuhamed.selenium.stepsdefs.searchflights;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.salle.rmuhamed.selenium.domain.FlightDTO;
import es.salle.rmuhamed.selenium.pages.FlightListPage;
import es.salle.rmuhamed.selenium.pages.SearchFlightPage;
import es.salle.rmuhamed.selenium.services.SearchFlightsService;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFlightsStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String WEB_ROOT = "https://vueling.com/es/";
    public static final String TU_BUSQUEDA_LABEL = "Tu búsqueda:";

    @Steps
    private SearchFlightsService searchFlightsService;

    private SearchFlightPage searchFlightPage;

    private FlightListPage flightListPage;

    private List<FlightDTO> flights;

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
    public void iTryToFindAFlight(List<FlightDTO> flightDto) throws Throwable {
        LOGGER.debug("iTryToFindAFlight starts");

        this.flights = flightDto;

        this.searchFlightPage.addCriteria(flightDto.get(0));
    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() throws Throwable {
        LOGGER.debug("iGetAvailableFlight starts");

        String label = this.flightListPage.getTuBusquedaLabel();

        assertThat(label)
                .as("Looking for tu busqueda label")
                .isNotNull()
                .isEqualTo(TU_BUSQUEDA_LABEL);
    }
}
