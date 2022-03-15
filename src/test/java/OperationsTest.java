import models.DivisionResult;
import models.Operations;
import models.Polynomial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {
    @Test
    public void addTest(){
        Polynomial polynomial1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial polynomial2 = new Polynomial("x^2-1");

        Polynomial resultPolynomial = Operations.add(polynomial1, polynomial2);

        Polynomial trueResultPolynomial = new Polynomial("x^3-x^2+6x-6");

        assertTrue( resultPolynomial.equals(trueResultPolynomial),
                "Rezultatul adunarii x^3-2x^2+6x-5 cu x^2-1 e x^3-x^2+6x-6" );
    }

    @Test
    public void substractionTest(){
        Polynomial polynomial1 = new Polynomial("2x^4-3x^3-15x^2+32x-12");
        Polynomial polynomial2 = new Polynomial("x^2-4x-12");

        Polynomial resultPolynomial = Operations.substract(polynomial1, polynomial2);

        Polynomial trueResultPolynomial = new Polynomial("2x^4-3x^3-16x^2+36x");

        assertTrue( resultPolynomial.equals(trueResultPolynomial),
                "Rezultatul scaderii x^3-2x^2+6x-5 cu x^2-1 e 2x^4-3x^3-16x^2+36x" );
    }

    @Test
    public void derivateTest(){
        Polynomial polynomial = new Polynomial("2x^4-3x^3-15x^2+32x-12");

        Polynomial resultPolynomial = Operations.derivate(polynomial);

        Polynomial trueResultPolynomial = new Polynomial("8x^3-9x^2-30x+32");

        assertTrue( resultPolynomial.equals(trueResultPolynomial),
                "Rezultatul derivarii 2x^4-3x^3-15x^2+32x-12 e 8x^3-9x^2-30x+32" );
    }

    @Test
    public void integrateTest(){
        Polynomial polynomial = new Polynomial("-5x^4+3x^2+2x+35");

        Polynomial resultPolynomial = Operations.integrate(polynomial);

        Polynomial trueResultPolynomial = new Polynomial("-x^5+x^3+x^2+35x");

        assertTrue( resultPolynomial.equals(trueResultPolynomial),
                "Rezultatul integrarii -x^4+x^2+2x+35 e -x^5+x^3+x^2+35x" );
    }

    @Test
    public void multiplicateTest(){
        Polynomial polynomial1 = new Polynomial("18x^3-x^2+2x");
        Polynomial polynomial2 = new Polynomial("26x^5-x^3-x^2+4x+1");

        Polynomial resultPolynomial = Operations.multiplicate(polynomial1, polynomial2);

        Polynomial trueResultPolynomial = new Polynomial("468x^8-26x^7+34x^6-17x^5+71x^4+12x^3+7x^2+2x");

        assertTrue( resultPolynomial.equals(trueResultPolynomial),
                "Rezultatul inmultirii 18x^3-x^2+2x cu 26x^5-x^3-x^2+4x+1 e 468x^8−26x^7+34x^6−17x^5+71x^4+12x^3+7x^2+2x" );
    }

    @Test
    public void divideTest(){
        Polynomial polynomial1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial polynomial2 = new Polynomial("x^2-1");

        try {
            DivisionResult divisionResult = Operations.divide(polynomial1, polynomial2);
            DivisionResult trueDivisionResult = new DivisionResult(new Polynomial("x-2"),
                    new Polynomial("7x-7"));

            assertTrue( trueDivisionResult.equals(divisionResult),
                    "Rezultatul impartirii x^3-2x^2+6x-5 cu x^2-1 e x-2 rest 7x-7" );
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
