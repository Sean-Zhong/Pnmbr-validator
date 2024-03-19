public class OrgStrategy implements ValidationStrategy {

    @Override
    public Boolean validate(String pnmbr) {
        if (!LuhnsAlgo.validLuhns(pnmbr)) {
            return false;
        }
        return true;
    }
    
}
