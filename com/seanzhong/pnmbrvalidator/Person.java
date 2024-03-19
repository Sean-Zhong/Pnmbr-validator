package com.seanzhong.pnmbrvalidator;
import java.util.logging.Logger;

public class Person {
    private NumberType type = NumberType.UNKNOWN;
    private String nmbr = "INVALID_INPUT";
    private boolean valid = false;

    private static final Logger logger = LoggingUtility.getLogger();

    public Person(String pnmbr) {
        if (validInput(pnmbr)) {
            nmbr = pnmbr;
            NumberType nType = checkNumberType(pnmbr);
            type = nType;

            ValidationStrategy strategy = null;
            switch (nType) {
                case REG:
                    strategy = new RegStrategy();
                    break;
                case COORD:
                    strategy = new CoordStrategy();
                    break;
                case ORG:
                    strategy = new OrgStrategy();
                    break;

                default:
                    logger.warning("No NumberType detected for personal number: " + pnmbr);
                    break;
            }

            boolean validStatus = strategy.validate(pnmbr);
            valid = validStatus;
        }
    }

    private static boolean validInput(String pnmbr) {
        String twelveDigits = "^\\d{12}$";
        String twelveDigitsMinus = "^\\d{8}-\\d{4}$";
        String tenDigits = "^\\d{10}$";
        String tenDigitsMinus = "^\\d{6}-\\d{4}$";
        String tenDigitsPlus = "^\\d{6}\\+\\d{4}$";

        if (!(pnmbr.matches(twelveDigits) ||
              pnmbr.matches(twelveDigitsMinus) ||
              pnmbr.matches(tenDigits) ||
              pnmbr.matches(tenDigitsMinus) ||
              pnmbr.matches(tenDigitsPlus))) {
            logger.warning("Invalid input format detected for personal number: " + pnmbr);
            return false;
        }
        return true;
    }
    



    private static NumberType checkNumberType(String pnmbr) {
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        if (Character.getNumericValue(pnmbrDigits.charAt(pnmbrDigits.length()-8)) >= 2) {
            return NumberType.ORG;
        }
        if (pnmbrDigits.length() == 12 && pnmbrDigits.substring(0, 2) == "16") {
            return NumberType.ORG;
        }
        int day = Integer.parseInt(pnmbrDigits.substring(pnmbrDigits.length()-6, pnmbrDigits.length()-4));
        if (day >= 61 && day <= 91) {
            return NumberType.COORD;
        }
        return NumberType.REG;
    }

    public NumberType getNumberType() {
        return type;
    }

    public String getPnmbr() {
        return nmbr;
    }

    public boolean getValid() {
        return valid;
    }

    public void setNumberType(NumberType ntype) {
        this.type = ntype;
    }

    public void setPnmbr(String pnmbr) {
        this.nmbr = pnmbr;
    }

    public void setValid(boolean vld) {
        this.valid = vld;
    }

    @Override
    public String toString() {
        return nmbr + "," + type + "," + valid;
    }
}
