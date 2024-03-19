public class RegStrategy implements ValidationStrategy {

    @Override
    public Boolean validate(String pnmbr) {
        if (!DateValidator.isDateValid(pnmbr)) {
            return false;
        }
        if (!LuhnsAlgo.validLuhns(pnmbr)){
            return false;
        }
        return true;
    }
}