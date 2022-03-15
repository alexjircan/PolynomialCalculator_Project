package controllers;

import models.DivisionResult;
import models.Operations;
import models.Polynomial;
import views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    public MainController(MainView mainView) {
        mainView.getDivideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial(mainView.getFirstPolynomialField());
                Polynomial polynomial2 = new Polynomial(mainView.getSecondPolynomialField());

                try {
                    DivisionResult divisionResult = Operations.divide(polynomial1, polynomial2);
                    mainView.setResultPolynomialField( divisionResult.getQuotient().toString() );
                    mainView.setRemainderPolynomialField( divisionResult.getRemainder().toString() );

                    mainView.setRemainderPolynomialVisibility(true);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(mainView, ex.getMessage());
                }
            }
        });
        mainView.getMultiplicateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial(mainView.getFirstPolynomialField());
                Polynomial polynomial2 = new Polynomial(mainView.getSecondPolynomialField());


                Polynomial resultPolynomial = Operations.multiplicate(polynomial1, polynomial2);

                mainView.setResultPolynomialField(resultPolynomial.toString());
                mainView.setRemainderPolynomialVisibility(false);
            }
        });

        mainView.getIntegrateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial = new Polynomial(mainView.getFirstPolynomialField());
                Polynomial resultPolynomial = Operations.integrate(polynomial);

                mainView.setResultPolynomialField(resultPolynomial.toString());
                mainView.setRemainderPolynomialVisibility(false);
            }
        });

        mainView.getDerivateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial = new Polynomial( mainView.getFirstPolynomialField() );
                Polynomial resultPolynomial = Operations.derivate(polynomial);

                mainView.setResultPolynomialField(resultPolynomial.toString());
                mainView.setRemainderPolynomialVisibility(false);
            }
        });

        mainView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial( mainView.getFirstPolynomialField() );
                Polynomial polynomial2 = new Polynomial( mainView.getSecondPolynomialField() );

                Polynomial resultPolynomial = Operations.add(polynomial1, polynomial2);

                mainView.setResultPolynomialField( resultPolynomial.toString() );
                mainView.setRemainderPolynomialVisibility(false);
            }
        });

        mainView.getSubstractButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial( mainView.getFirstPolynomialField() );
                Polynomial polynomial2 = new Polynomial( mainView.getSecondPolynomialField() );

                Polynomial resultPolynomial = Operations.substract(polynomial1, polynomial2);

                mainView.setResultPolynomialField( resultPolynomial.toString() );
                mainView.setRemainderPolynomialVisibility(false);
            }
        });

        mainView.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
