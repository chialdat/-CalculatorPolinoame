package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;

public class DashboardView extends JFrame{

    private JPanel contentPane;
    private JLabel titleLabel;
    private JTextField firstTextField;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JTextField secondField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private JButton derivateButton;
    private JButton integrationButton;
    private JLabel finalLabel;
    private JLabel result;

    public DashboardView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(238, 130, 238));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(238, 130, 238));
        contentPane.add(panel1);

        titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel1.add(titleLabel);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(238, 130, 238));
        contentPane.add(panel2);

        firstLabel = new JLabel("First Polynomial = ");
        firstLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel2.add(firstLabel);

        firstTextField = new JTextField();
        panel2.add(firstTextField);
        firstTextField.setColumns(20);

        secondLabel = new JLabel("Second Polynomial = ");
        secondLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel2.add(secondLabel);

        secondField = new JTextField();
        panel2.add(secondField);
        secondField.setColumns(20);
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(238, 130, 238));
        contentPane.add(panel3);

        finalLabel = new JLabel("Result: ");
        finalLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel3.add(finalLabel);

        result = new JLabel("");
        result.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel3.add(result);

        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(238, 130, 238));
        contentPane.add(panel4);

        addButton = new JButton("Add");
        addButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel4.add(addButton);

        subtractButton = new JButton("Subtract");
        subtractButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel4.add(subtractButton);

        multiplyButton = new JButton("Multiply");
        multiplyButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel4.add(multiplyButton);

        divisionButton = new JButton("Division");
        divisionButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel4.add(divisionButton);

        derivateButton = new JButton("Derivate");
        derivateButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel4.add(derivateButton);

        integrationButton = new JButton("Integration");
        integrationButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        panel4.add(integrationButton);

        setVisible(true);
    }

    public void addButtonListener(ActionListener aL){
        this.addButton.addActionListener(aL);
    }

    public void subtractButtonListener(ActionListener aL){
        this.subtractButton.addActionListener(aL);
    }

    public void multiplyButtonListener(ActionListener aL){
        this.multiplyButton.addActionListener(aL);
    }

    public void divisionButtonListener(ActionListener aL){
        this.divisionButton.addActionListener(aL);
    }

    public void integrationButtonListener(ActionListener aL){
        this.integrationButton.addActionListener(aL);
    }

    public void derivateButtonListener(ActionListener aL){
        this.derivateButton.addActionListener(aL);
    }

    public String getFirstText(){
        return firstTextField.getText();
    }

    public String getSecondText(){
        return secondField.getText();
    }

    public void setResultLabel(String rez){
        this.result.setText(rez);
    }

}
