import java.time.LocalDate;

public class temp {

    public static void main(String[] args) {
        LocalDate dateToCheck = LocalDate.of(2023, 01, 29);
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        
        if (isWithinRange(dateToCheck, startDate, endDate)) {
            System.out.println(dateToCheck + " is within the specified range.");
        } else {
            System.out.println(dateToCheck + " is NOT within the specified range.");
        }
    }
    
    public static boolean isWithinRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
