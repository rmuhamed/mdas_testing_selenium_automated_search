package es.salle.rmuhamed.selenium.services;

import es.salle.rmuhamed.selenium.builders.SearchFlightCriteriaDataBuilder;
import es.salle.rmuhamed.selenium.domain.SearchFlightCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class SearchFlightsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public List<SearchFlightCriteria> addSearchFlightCriteria() {
        LOGGER.debug("addSearchFlightCriteria starts");

        List<SearchFlightCriteria> searchFlightCriteria = new ArrayList<>(1);
        searchFlightCriteria.add(this.generateSearchCriteria());

        return searchFlightCriteria;
    }

    private SearchFlightCriteria generateSearchCriteria() {
        return SearchFlightCriteriaDataBuilder.defaultCriteria().build();
    }

    public void clean() {
        LOGGER.debug("clean");
    }
}
