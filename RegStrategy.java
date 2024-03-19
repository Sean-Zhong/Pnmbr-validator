import java.util.logging.Logger;

public class RegStrategy implements ValidationStrategy {
    private static final Logger logger = LoggingUtility.getLogger();

    @Override
    public boolean validate(String pnmbr) {
        if (!DateValidator.isDateValid(pnmbr)) {
            logger.warning("Date validation failed for personal number: " + pnmbr);
            return false;
        }
        if (!LuhnsAlgo.validLuhns(pnmbr)) {
            logger.warning("Luhn's algorithm validation failed for personal number: " + pnmbr);
            return false;
        }
        return true;
    }
}