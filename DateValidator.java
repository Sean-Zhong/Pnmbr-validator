import java.time.LocalDate;
import java.time.Year;

public class DateValidator {
    public static Boolean isDateValid(String pnmbr) {
        LocalDate START_DATE = LocalDate.of(1840, 05, 06);
        LocalDate currentDate = LocalDate.now();
        int century = 0;
        int decadeAndYear = 0;
        String currentYear = Year.now().toString();
        int currentMonth = currentDate.getMonth().getValue();
        int currentDay = currentDate.getDayOfMonth();
        int currentCentury = Integer.parseInt(currentYear.substring(0, 2));
        int currentDecadeAndYear = Integer.parseInt(currentYear.substring(1, 4));
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        int year = 0;
        int month = Integer.parseInt(pnmbrDigits.substring(pnmbrDigits.length()-8, pnmbrDigits.length()-6));
        int day = Integer.parseInt(pnmbrDigits.substring(pnmbrDigits.length()-6, pnmbrDigits.length()-4));

        if (pnmbrDigits.length() == 12) {
            year = Integer.parseInt(pnmbrDigits.substring(0, 4));
        } else {
            decadeAndYear = Integer.parseInt(pnmbrDigits.substring(0, 2));
            century = currentCentury;
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
            return !dateToCheck.isBefore(START_DATE) && !dateToCheck.isAfter(currentDate);
        } catch (Exception e) {
            // log about exception
            return false;
        }
    }
}
