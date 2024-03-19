public class CoordStrategy implements ValidationStrategy {

    @Override
    public Boolean validate(String pnmbr) {
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        int digitAdjusted = Character.getNumericValue(pnmbrDigits.charAt(pnmbrDigits.length()-6))-6;
        char charAdjusted = Character.forDigit(digitAdjusted, 10);

        StringBuilder str = new StringBuilder(pnmbrDigits);
        str.setCharAt(pnmbrDigits.length()-6, charAdjusted);
        if (str.length() < pnmbr.length()) {
            char separator = pnmbr.charAt(pnmbr.length()-5);
            str.insert(separator, str.length()-5);
        }

        if (!DateValidator.isDateValid(str.toString())) {
            return false;
        }
        if (!LuhnsAlgo.validLuhns(pnmbr)) {
            return false;
        }
        return true;
    }
    
}
