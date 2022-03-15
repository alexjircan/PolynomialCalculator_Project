package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> monomials;

    public Polynomial() {
        this.monomials = new ArrayList<Monomial>();
    }

    public Polynomial(Polynomial polynomial){
        this.monomials = new ArrayList<Monomial>();
        this.monomials.addAll(polynomial.getMonomials());
    }

    public Polynomial(String polynomialString) {
        this.monomials = new ArrayList<Monomial>();

        polynomialString = polynomialString.replaceAll("\\s", "");
        Pattern pattern = Pattern.compile("(([+-]?([0-9]+)?)\\*?x(\\^([0-9]+))?)|([+-]?[0-9]+)");
        Matcher matcher = pattern.matcher(polynomialString);
        int i = 1;
        while (matcher.find()) {
            float coefficient = 0;
            int power = 0;

            if (null == matcher.group(6)) {
                if (null != matcher.group(2) && !matcher.group(2).equals("")) {
                    if (matcher.group(2).equals("-")) coefficient = -1;
                    else if (matcher.group(2).equals("+")) coefficient = 1;
                    else coefficient = Float.parseFloat(matcher.group(2));
                }
                else coefficient = 1;
                if (null != matcher.group(5)) power = Integer.parseInt(matcher.group(5));
                else power = 1;
            } else {
                coefficient = Integer.parseInt(matcher.group(6));
            }

            this.addMonomial(new Monomial(coefficient, power));
        }

        Collections.sort(this.getMonomials());
    }

    public int getDegree(){
        if(this.getMonomials().isEmpty()) return 0;
        return this.getMonomials().get(0).getPower();
    }

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Polynomial) ) return super.equals(obj);

        int i = 0;
        if( this.getSize() != ((Polynomial) obj).getSize() ) return false;
        for (Monomial monomial: ((Polynomial) obj).getMonomials()) {
            if( !monomial.equals(this.monomials.get(i++)) ) return false;
        }
        return true;
    }

    @Override
    public String toString(){
        String result = "";
        for (Monomial monomial:
             monomials) {
            result += monomial.toString();
        }

        if(result.equals("")) result += "0";
        else if(result.charAt(0) == '+') result = result.substring(1);

        result = "<html>" + result + "</html>";
        return result;
    }

    public void clear(){
        this.monomials.clear();
    }

    public int getSize() {
        return this.monomials.size();
    }

    public void addMonomial(Monomial monomial) {
        if(monomial.getCoefficient() != 0)
            this.monomials.add(monomial);
    }

    public Monomial getLastMonomial(){
        if( this.getSize() == 0 ) return new Monomial(0, 0);
        return monomials.get(monomials.size()-1);
    }

    public Monomial getFirstMobomial(){
        if( this.getSize() == 0 ) return new Monomial(0, 0);
        return monomials.get(0);
    }
    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }
}
