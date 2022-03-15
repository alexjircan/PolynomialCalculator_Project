package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainView extends JFrame {

    private JTextField firstPolynomialField;
    private JTextField secondPolynomialField;
    private JLabel resultPolynomialField;
    private JLabel remainderPolynomialField;
    private JLabel remainderPolynomialLabel;
    private JPanel inputPanel;
    private JButton exitButton;
    private JButton addButton;
    private JButton divideButton;
    private JButton substractButton;
    private JButton integrateButton;
    private JButton derivateButton;
    private JButton multiplicateButton;

    public MainView(){
        this.setMinimumSize(new Dimension(600, 500));
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout(0, 0));

        JLabel titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        titleLabel.setVerticalAlignment(SwingConstants.TOP);
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        this.getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(2, 0, 0, 0));

        inputPanel = new JPanel();
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.add(inputPanel);
        inputPanel.setLayout(new GridLayout(4, 2, 0, 5));

        JLabel firstPolynomialLabel = new JLabel("First Polynomial =");
        firstPolynomialLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPolynomialLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inputPanel.add(firstPolynomialLabel);

        firstPolynomialField = new JTextField();
        firstPolynomialField.setHorizontalAlignment(SwingConstants.CENTER);
        firstPolynomialField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        firstPolynomialField.setColumns(10);
        inputPanel.add(firstPolynomialField);

        JLabel secondPolynomialLabel = new JLabel("Second Polynomial =");
        secondPolynomialLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secondPolynomialLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inputPanel.add(secondPolynomialLabel);

        secondPolynomialField = new JTextField();
        secondPolynomialField.setHorizontalAlignment(SwingConstants.CENTER);
        secondPolynomialField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        secondPolynomialField.setColumns(10);
        inputPanel.add(secondPolynomialField);

        JLabel resultPolynomialLabel = new JLabel("Result Polynomial =");
        resultPolynomialLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultPolynomialLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inputPanel.add(resultPolynomialLabel);

        resultPolynomialField = new JLabel("");
        resultPolynomialField.setHorizontalAlignment(SwingConstants.CENTER);
        resultPolynomialField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inputPanel.add(resultPolynomialField);

        remainderPolynomialLabel = new JLabel("Result Polynomial Remainder =");
        remainderPolynomialLabel.setHorizontalAlignment(SwingConstants.CENTER);
        remainderPolynomialLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inputPanel.add(remainderPolynomialLabel);

        remainderPolynomialField = new JLabel("");
        remainderPolynomialField.setHorizontalAlignment(SwingConstants.CENTER);
        remainderPolynomialField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inputPanel.add(remainderPolynomialField);

        JPanel panel_2 = new JPanel();
        contentPanel.add(panel_2);
        panel_2.setLayout(new GridLayout(4, 3, 5, 5));

        multiplicateButton = new JButton("Multiplicate");
        multiplicateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(multiplicateButton);

        substractButton = new JButton("Substract");
        substractButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(substractButton);

        divideButton = new JButton("Divide");
        divideButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(divideButton);

        addButton = new JButton("Add");
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(addButton);

        integrateButton = new JButton("Integrate");
        integrateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(integrateButton);

        derivateButton = new JButton("Derivate");
        derivateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(derivateButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(exitButton);

        this.setVisible(true);
        this.setRemainderPolynomialVisibility(false);
    }

    public void setRemainderPolynomialField(String text) {
        this.remainderPolynomialField.setText(text);
    }

    public void setRemainderPolynomialVisibility(boolean visibility){
        if(!visibility) {
            this.inputPanel.setLayout(new GridLayout(3, 2, 0, 5));
            this.inputPanel.remove(remainderPolynomialLabel);
            this.inputPanel.remove(remainderPolynomialField);
        }
        else{
            this.inputPanel.setLayout(new GridLayout(4, 2, 0, 5));
            this.inputPanel.add(remainderPolynomialLabel);
            this.inputPanel.add(remainderPolynomialField);
        }
        this.inputPanel.repaint();
        this.inputPanel.revalidate();
    }

    public void setResultPolynomialField(String text){
        this.resultPolynomialField.setText(text);
    }

    public String getFirstPolynomialField() {
        return firstPolynomialField.getText();
    }

    public String getSecondPolynomialField() {
        return secondPolynomialField.getText();
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getSubstractButton() {
        return substractButton;
    }

    public JButton getMultiplicateButton() {
        return multiplicateButton;
    }

    public JButton getDerivateButton(){ return derivateButton; }

    public JButton getIntegrateButton() { return integrateButton; }
}
