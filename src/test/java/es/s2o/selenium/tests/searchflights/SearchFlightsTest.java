package es.s2o.selenium.tests.searchflights;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/searchflights",
        glue = "es.s2o.selenium.stepsdefs.searchflights")
public class SearchFlightsTest extends RunnerBase{}
