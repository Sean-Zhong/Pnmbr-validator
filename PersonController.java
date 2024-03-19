public class PersonController {
    public static Person controll(String pnmbr) {
        Person person = new Person(null, pnmbr, false);
        if (validInput(pnmbr)) {
            NumberType nType = checkNumberType(pnmbr);
            person.setNumberType(nType);

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
                    // return some error here
                    break;
            }

            Boolean validStatus = strategy.validate(pnmbr);
            person.setValid(validStatus);
        }
        return person;
    }
    
    public static Boolean validInput(String pnmbr) {
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        if (pnmbrDigits.length() > 12 || pnmbrDigits.length() < 10) {
            return false;
        }
        // Double check if regex works
        if (pnmbr.matches("[^0-9\\+\\-]")) {
            return false;
        }
        return true;
    }

    public static NumberType checkNumberType(String pnmbr) {
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
}