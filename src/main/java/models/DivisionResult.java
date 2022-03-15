package models;

public class DivisionResult {
    private Polynomial quotient;
    private Polynomial remainder;

    public DivisionResult(){
        this.quotient = new Polynomial();
        this.remainder = new Polynomial();
    }

    public DivisionResult(Polynomial quotient, Polynomial remainder){
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public void setRemainder(Polynomial remainder) {
        this.remainder = remainder;
    }

    @Override
    public boolean equals(Object obj){
        if( !(obj instanceof DivisionResult) ) return super.equals(obj);
        return ((DivisionResult) obj).getQuotient().equals(this.quotient) &&
                ((DivisionResult) obj).getRemainder().equals(this.remainder);
    }

    public Polynomial getQuotient() {
        return quotient;
    }
    public Polynomial getRemainder() {
        return remainder;
    }
}
