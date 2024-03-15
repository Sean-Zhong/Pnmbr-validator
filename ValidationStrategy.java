import java.time.LocalDate;

public interface ValidationStrategy {
    public static final LocalDate START_DATE = LocalDate.of(1850, 1, 1);
    public Boolean validate(String pnmbr);
}