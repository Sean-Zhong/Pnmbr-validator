import java.text.ParseException;
import java.time.LocalDate;


public class RegStrategy implements ValidationStrategy {

    @Override
    public Boolean validate(String pnmbr) {
        // Validate year
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");

        if (!isDateValid(pnmbr)) {
            return false;
        }


        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }

    private Boolean isDateValid(String pnmbr) {
        try {
            LocalDate currentDate = LocalDate.now();
            int year = 0;
            int month = 0;
            int day = 0;
            String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");

            if (pnmbrDigits.length() == 12) {
                year = Integer.parseInt(pnmbrDigits.substring(0, 3));
            } else {
                if (pnmbr.contains("+")) {
                    year = Integer.parseInt(pnmbrDigits.substring(0, 1));
                }
            }
            LocalDate dateToCheck = LocalDate.of(year, month, day);
            return !dateToCheck.isBefore(START_DATE) && !dateToCheck.isAfter(currentDate);
        } catch (Exception e) {
            return false;
        }
    }
}