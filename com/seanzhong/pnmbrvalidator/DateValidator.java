package com.seanzhong.pnmbrvalidator;
import java.time.LocalDate;
import java.time.Year;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DateValidator {
    private static final Logger logger = LoggingUtility.getLogger();

    public static boolean isDateValid(String pnmbr) {
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        LocalDate startDate = LocalDate.of(1840, 05, 06); //Earliest pnmbr
        LocalDate currentDate = LocalDate.now();
        
        String currentYear = Year.now().toString();
        int currentMonth = currentDate.getMonth().getValue();
        int currentDay = currentDate.getDayOfMonth();
        int currentCentury = Integer.parseInt(currentYear.substring(0, 2));
        int currentDecadeAndYear = Integer.parseInt(currentYear.substring(1, 4));

        int year = 0;
        int month = Integer.parseInt(pnmbrDigits.substring(pnmbrDigits.length()-8, pnmbrDigits.length()-6));
        int day = Integer.parseInt(pnmbrDigits.substring(pnmbrDigits.length()-6, pnmbrDigits.length()-4));

        if (pnmbrDigits.length() == 12) {
            year = Integer.parseInt(pnmbrDigits.substring(0, 4));
        } else {
            int decadeAndYear = Integer.parseInt(pnmbrDigits.substring(0, 2));
            int century = currentCentury;
            if (decadeAndYear > currentDecadeAndYear) {
                century -= 1;
            } else if (decadeAndYear == currentDecadeAndYear) {
                if (month > currentMonth) {
                    century -= 1;
                } else if (month == currentMonth && day > currentDay) {
                    century -= 1;
                }
            }
            if (pnmbr.contains("+")) {
                century -= 1;
            }
            year = 100 * century + decadeAndYear;
        }
        try {
            LocalDate dateToCheck = LocalDate.of(year, month, day);
            return !dateToCheck.isBefore(startDate) && !dateToCheck.isAfter(currentDate);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception occured while validating date for personal number: " + pnmbr, e.getMessage());
            return false;
        }
    }
}
