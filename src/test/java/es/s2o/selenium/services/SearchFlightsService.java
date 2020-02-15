package es.s2o.selenium.services;

import es.s2o.selenium.builders.SearchFlightCriteriaDataBuilder;
import es.s2o.selenium.domain.SearchFlightCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class SearchFlightsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public List<SearchFlightCriteria> addSearchFlightCriteria() {
        LOGGER.debug("addSearchFlightCriteria starts");

        List<SearchFlightCriteria> searchFlightCriteriaDto = new ArrayList<>(1);
        searchFlightCriteriaDto.add(this.generateSearchCriteria());

        return searchFlightCriteriaDto;
    }

    private SearchFlightCriteria generateSearchCriteria() {
        return SearchFlightCriteriaDataBuilder.defaultCriteria().build();
    }

    public void clean() {
        LOGGER.debug("clean");
    }
}
