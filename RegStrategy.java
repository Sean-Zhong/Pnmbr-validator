import java.time.LocalDate;
import java.time.Year;


public class RegStrategy implements ValidationStrategy {

    @Override
    public Boolean validate(String pnmbr) {
        // Validate year
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");

        if (!isDateValid(pnmbr)) {
            return false;
        }

    }

    private Boolean isDateValid(String pnmbr) {
        LocalDate currentDate = LocalDate.now();
        int year = 0;
        int month = 0;
        int day = 0;
        int century = 0;
        int decadeAndYear = 0;
        String currentYear = Year.now().toString();
        int currentCentury = Integer.parseInt(currentYear.substring(0, 2));
        int currentDecadeAndYear = Integer.parseInt(currentYear.substring(1, 4));
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");

        if (pnmbrDigits.length() == 12) {
            year = Integer.parseInt(pnmbrDigits.substring(0, 4));
        } else {
            decadeAndYear = Integer.parseInt(pnmbrDigits.substring(0, 2));
            century = currentCentury;
            if (decadeAndYear > currentDecadeAndYear) {
                century -= 1;
            }
            if (pnmbr.contains("+")) {
                century -= 1;
            }
            year = 1000 * century + decadeAndYear;
        }
        month = Integer.parseInt(pnmbrDigits.substring(pnmbrDigits.length()-8, pnmbrDigits.length()-6));
        day = Integer.parseInt(pnmbrDigits.substring(pnmbrDigits.length()-6, pnmbrDigits.length()-4));
        try {
            LocalDate dateToCheck = LocalDate.of(year, month, day);
            return !dateToCheck.isBefore(START_DATE) && !dateToCheck.isAfter(currentDate);
        } catch (Exception e) {
            return false;
        }
    }
}