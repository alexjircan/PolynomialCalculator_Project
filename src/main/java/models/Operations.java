package models;

import java.util.Iterator;

public class Operations {
    public static DivisionResult divide(Polynomial firstPolynomial, Polynomial secondPolynomial) throws Exception {
        DivisionResult divisionResult = new DivisionResult();

        Polynomial auxPolynomial = new Polynomial(firstPolynomial);

        if( secondPolynomial.getDegree() == 0 ){
            if( secondPolynomial.getFirstMobomial().getCoefficient() == 0 ) throw new Exception("Division by 0");
            for (Monomial monomial: auxPolynomial.getMonomials()) {
                divisionResult.getQuotient().addMonomial(new Monomial(
                        monomial.getCoefficient()/secondPolynomial.getFirstMobomial().getCoefficient(),
                        monomial.getPower() ));
            }
            return divisionResult;
        }

        while(auxPolynomial.getDegree() >= secondPolynomial.getDegree() ){
            divisionResult.getQuotient().addMonomial(new Monomial(
                    auxPolynomial.getFirstMobomial().getCoefficient()/ secondPolynomial.getFirstMobomial().getCoefficient(),
                    auxPolynomial.getFirstMobomial().getPower() - secondPolynomial.getFirstMobomial().getPower()
            ));
            divisionResult.setRemainder(Operations.multiplicate(divisionResult.getQuotient().getLastMonomial(), secondPolynomial));
            auxPolynomial = Operations.substract(auxPolynomial, divisionResult.getRemainder());
        }

        divisionResult.setRemainder( auxPolynomial );

        return divisionResult;
    }

    public static Polynomial multiplicate(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial resultPolynomial = new Polynomial();
        Polynomial auxPolynomial = new Polynomial();

        for(Monomial firstMon: firstPolynomial.getMonomials()){
            for(Monomial secondMon: secondPolynomial.getMonomials()){
                auxPolynomial.addMonomial( new Monomial(
                        firstMon.getCoefficient() * secondMon.getCoefficient(),
                        firstMon.getPower() + secondMon.getPower()
                ));
            }
            resultPolynomial = Operations.add(resultPolynomial, auxPolynomial);
            auxPolynomial.clear();
        }
        return resultPolynomial;
    }

    public static Polynomial multiplicate(Monomial monomial, Polynomial polynomial){
        Polynomial resultPolynomial = new Polynomial();
        Polynomial auxPolynomial = new Polynomial();

        for(Monomial secondMon: polynomial.getMonomials()){
            auxPolynomial.addMonomial( new Monomial(
                    monomial.getCoefficient() * secondMon.getCoefficient(),
                    monomial.getPower() + secondMon.getPower()
            ));
        }
        resultPolynomial = Operations.add(resultPolynomial, auxPolynomial);
        auxPolynomial.clear();

        return resultPolynomial;
    }

    public static Polynomial integrate(Polynomial polynomial) {
        Polynomial resultPolynomial = new Polynomial();

        for (Monomial monomial: polynomial.getMonomials()) {
            resultPolynomial.addMonomial(new Monomial(
                    monomial.getCoefficient() * ( 1/ (monomial.getPower() + 1.0f) ),
                    monomial.getPower() + 1
            ));
        }

        return resultPolynomial;
    }

    public static Polynomial derivate(Polynomial polynomial) {
        Polynomial resultPolynomial = new Polynomial();

        for (Monomial monomial : polynomial.getMonomials()) {
            if (monomial.getPower() != 0) {
                resultPolynomial.addMonomial(new Monomial(
                        monomial.getCoefficient() * monomial.getPower(),
                        monomial.getPower() - 1
                ));
            }
            else {
                resultPolynomial.addMonomial(new Monomial(0, 0));
            }
        }

        return resultPolynomial;
    }

    public static Polynomial add(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial resultPolynomial = new Polynomial();

        Iterator<Monomial> firstIterator = firstPolynomial.getMonomials().iterator();
        Iterator<Monomial> secondIterator = secondPolynomial.getMonomials().iterator();
        Monomial firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
        Monomial secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;

        while (firstMonomial != null && secondMonomial != null) {
            if (firstMonomial.getPower() == secondMonomial.getPower()) {
                resultPolynomial.addMonomial(new Monomial(firstMonomial.getCoefficient() + secondMonomial.getCoefficient(), firstMonomial.getPower()));
                firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
                secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;
            } else if (firstMonomial.getPower() > secondMonomial.getPower()) {
                resultPolynomial.addMonomial(new Monomial(firstMonomial.getCoefficient(), firstMonomial.getPower()));
                firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
            } else {
                resultPolynomial.addMonomial(new Monomial(secondMonomial.getCoefficient(), secondMonomial.getPower()));
                secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;
            }
        }
        while (firstMonomial != null) {
            resultPolynomial.addMonomial(new Monomial(firstMonomial.getCoefficient(), firstMonomial.getPower()));
            firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
        }
        while (secondMonomial != null) {
            resultPolynomial.addMonomial(new Monomial(secondMonomial.getCoefficient(), secondMonomial.getPower()));
            secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;
        }
        return resultPolynomial;
    }

    public static Polynomial substract(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial resultPolynomial = new Polynomial();
        Iterator<Monomial> firstIterator = firstPolynomial.getMonomials().iterator();
        Iterator<Monomial> secondIterator = secondPolynomial.getMonomials().iterator();
        Monomial firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
        Monomial secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;

        while (firstMonomial != null && secondMonomial != null) {
            if (firstMonomial.getPower() == secondMonomial.getPower()) {
                resultPolynomial.addMonomial(new Monomial(firstMonomial.getCoefficient() - secondMonomial.getCoefficient(), firstMonomial.getPower()));
                firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
                secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;
            } else if (firstMonomial.getPower() > secondMonomial.getPower()) {
                resultPolynomial.addMonomial(new Monomial(firstMonomial.getCoefficient(), firstMonomial.getPower()));
                firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
            } else {
                resultPolynomial.addMonomial(new Monomial(-secondMonomial.getCoefficient(), secondMonomial.getPower()));
                secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;
            }
        }
        while (firstMonomial != null) {
            resultPolynomial.addMonomial(new Monomial(firstMonomial.getCoefficient(), firstMonomial.getPower()));
            firstMonomial = firstIterator.hasNext() ? firstIterator.next() : null;
        }
        while (secondMonomial != null) {
            resultPolynomial.addMonomial(new Monomial(-secondMonomial.getCoefficient(), secondMonomial.getPower()));
            secondMonomial = secondIterator.hasNext() ? secondIterator.next() : null;
        }

        return resultPolynomial;
    }
}
