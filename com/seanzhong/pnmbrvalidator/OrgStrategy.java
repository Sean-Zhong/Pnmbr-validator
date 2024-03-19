package com.seanzhong.pnmbrvalidator;
import java.util.logging.Logger;

public class OrgStrategy implements ValidationStrategy {
    private static final Logger logger = LoggingUtility.getLogger();

    @Override
    public boolean validate(String pnmbr) {
        if (!LuhnsAlgo.validLuhns(pnmbr)) {
            logger.warning("Luhn's algorithm validation failed for personal number: " + pnmbr);
            return false;
        }
        return true;
    }
}
