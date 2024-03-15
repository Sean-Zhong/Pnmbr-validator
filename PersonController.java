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
        /*
        1. Check if org or not org by:
        check index -8 =< 2 -> org
        check len
            if "12" and first two 16 -> org

        2. Check if regular or coord by:
        check index -5 and -6 if between 61-91 -> coord
        */
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        if (pnmbrDigits.charAt(-8) >= 2) {
            return NumberType.ORG;
        }
        if (pnmbrDigits.length() == 12 && pnmbrDigits.substring(0, 1) == "16") {
            return NumberType.ORG;
        }
        int day = Integer.parseInt(pnmbrDigits.substring(-6, -5));
        if (day >= 61 && day <= 91) {
            return NumberType.COORD;
        }
        return NumberType.REG;
    }
}