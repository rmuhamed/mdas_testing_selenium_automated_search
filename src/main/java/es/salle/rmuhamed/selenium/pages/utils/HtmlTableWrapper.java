package es.salle.rmuhamed.selenium.pages.utils;

import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class HtmlTableWrapper {
    public static final String BY_COLUMN = "./td";
    private final HtmlTable table;

    private List<WebElement> rowList;
    private List<WebElement> columnList;

    private HtmlTableWrapper(HtmlTable table) {
        this.table = table;
    }

    public static HtmlTableWrapper from(HtmlTable table) {
        return new HtmlTableWrapper(table);
    }

    public HtmlTableWrapper allTheRowsWithoutHeading() {
        this.rowList = this.table.getRowElementsFor(this.table.getHeadings());
        return this;
    }

    public HtmlTableWrapper toFlattenColumns() {
        this.columnList = this.rowList
                .parallelStream()
                .reduce(new ArrayList<>(),
                        (elements, anElement) -> {
                            elements.addAll(anElement.findElements(By.xpath(BY_COLUMN)));
                            return elements;
                        },
                        (BinaryOperator<List<WebElement>>) (elementList, anotherList) -> {
                            elementList.addAll(anotherList);
                            return elementList;
                        }
                );

        return this;
    }

    public WebElement findCellBy(String textToMatch) {
        if (this.columnList == null) {
            throw new RuntimeException("First you have to fill a list of <td>");
        }

        Optional<WebElement> aCell = this.columnList
                .stream()
                .filter(element -> element.getText().equals(textToMatch))
                .findFirst();

        if (aCell.isPresent()) {
            return aCell.get();
        }

        throw new RuntimeException("The day wanted couldn't be found");
    }
}
