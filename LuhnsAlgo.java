public class LuhnsAlgo {
    public static Boolean validLuhns(String pnmbr) {
        int sum = 0;
        boolean alternate = false;
        String pnmbrDigits = pnmbr.replaceAll("[^\\d.]", "");
        String tenDigitPnmbr = pnmbrDigits.substring(pnmbrDigits.length()-10, pnmbrDigits.length());
        
        for (int i = tenDigitPnmbr.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(tenDigitPnmbr.charAt(i));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        return sum % 10 == 0;
    }
}