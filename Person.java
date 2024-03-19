public class Person {
    private NumberType type;
    private String pnmbr;
    private Boolean valid;

    public Person(NumberType ntype, String nmbr, Boolean vld) {
        this.type = ntype;
        this.pnmbr = nmbr;
        this.valid = vld;
    }

    public NumberType getNumberType() {
        return type;
    }

    public String getPnmbr() {
        return pnmbr;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setNumberType(NumberType ntype) {
        this.type = ntype;
    }

    public void setPnmbr(String nmbr) {
        this.pnmbr = nmbr;
    }

    public void setValid(Boolean vld) {
        this.valid = vld;
    }

    @Override
    public String toString() {
        return pnmbr + "," + type + "," + valid;
    }
}
