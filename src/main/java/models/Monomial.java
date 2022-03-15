package models;

public class Monomial implements Comparable<Monomial> {
    private float coefficient;
    private int power;

    public Monomial(float coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Monomial) ) return super.equals(obj);

        return ((Monomial) obj).getCoefficient() == this.coefficient && ((Monomial) obj).getPower() == this.power;
    }

    @Override
    public String toString(){
        String result = "";
        if( this.coefficient != 1 && this.coefficient != -1 ){
            result += this.coefficient>0 ? "+" : "";
            result += this.coefficient%1 == 0.0 ?
                    String.format("%.0f", this.coefficient) :
                    String.format("%.2f", this.coefficient);;
        }
        else{
            result += (this.coefficient>0 ? "+" : "");
            if( this.power == 0 )
                result += this.coefficient%1 == 0.0 ?
                        String.format("%.0f", this.coefficient) :
                        String.format("%.2f", this.coefficient);
            else if(this.coefficient < 0) result += "-";
        }
        if(this.power > 0){
            result += "x";
            if(this.power > 1) result += "<sup>"+this.power+"</sup>";
        }

        return result;
    }

    @Override
    public int compareTo(Monomial monomial) {
        return Integer.compare(monomial.power, this.power);
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public int getPower() {
        return power;
    }

}
