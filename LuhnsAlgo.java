public class LuhnsAlgo {
    public static Boolean validLuhns(String pnmbr) {
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        String tenDigitPnmbr = pnmbrDigits.substring(pnmbrDigits.length()-10, pnmbrDigits.length());
        int[] numbers = tenDigitPnmbr.chars()
                     .map(Character::getNumericValue)
                     .toArray();
        
        // for loop with luhn calcs
        return false;
    }
}