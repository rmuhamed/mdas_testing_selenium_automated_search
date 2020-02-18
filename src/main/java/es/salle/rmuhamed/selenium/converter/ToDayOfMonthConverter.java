package es.salle.rmuhamed.selenium.converter;

import cucumber.api.Transformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDayOfMonthConverter extends Transformer<String> {

    public static final String DAY_OF_MONTH_FORMAT = "dd";
    public static final int ONE_WEEK_IN_DAYS = 7;
    public static final String NEXT_WEEK = "NEXT_WEEK";
    public static final String TODAY = "TODAY";

    @Override
    public String transform(String value) {
        String converted = "";
        switch (value) {
            case NEXT_WEEK:
                converted = this.getNextWeekDateFromToday();
                break;
            case TODAY:
                converted = this.getTodayDate();
                break;
            default:
                converted = this.getTomorrowDate();
        }

        return converted;
    }

    private String getTodayDate() {
        return this.getDateBy(0);
    }

    private String getNextWeekDateFromToday() {
        return this.getDateBy(ONE_WEEK_IN_DAYS);
    }

    private String getTomorrowDate() {
        return this.getDateBy(1);
    }

    private String getDateBy(int daysInFuture) {
        DateTimeFormatter desiredFormat = DateTimeFormatter.ofPattern(DAY_OF_MONTH_FORMAT);
        LocalDate today = LocalDate.now();
        LocalDate dateInFuture = today.plusDays(daysInFuture);

        return dateInFuture.format(desiredFormat);
    }
}
