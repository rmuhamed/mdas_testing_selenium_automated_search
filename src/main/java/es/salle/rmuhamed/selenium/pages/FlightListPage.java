package es.salle.rmuhamed.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class FlightListPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy (css = "#research > div:nth-child(1) > div.fs_11.underline.paddingBottom5")
    private List<WebElement> labelElement;

    public String getTuBusquedaLabel() {
        LOGGER.debug("Showing flights available starts here ...");

        if (labelElement == null) {
            return null;
        }

        if (labelElement.size() == 0) {
            return null;
        }

        return labelElement.get(0).getText();
    }

}
