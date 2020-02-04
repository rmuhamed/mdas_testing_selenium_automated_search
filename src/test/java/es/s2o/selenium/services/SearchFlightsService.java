package es.s2o.selenium.services;

import es.s2o.selenium.builders.SearchFlightCriteriaBuilder;
import es.s2o.selenium.builders.SearchFlightCriteriaDataBuilder;
import es.s2o.selenium.domain.SearchFlightCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SearchFlightsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public SearchFlightCriteria addSearchFlightCriteria() {
        LOGGER.debug("addSearchFlightCriteria starts");

        SearchFlightCriteria searchFlightCriteria = this.generateSearchCriteria();

        return searchFlightCriteria;
    }

    private SearchFlightCriteria generateSearchCriteria() {
        return SearchFlightCriteriaDataBuilder.defaultCriteria().build();
    }

    public void clean() {
        LOGGER.debug("clean");
    }
}
