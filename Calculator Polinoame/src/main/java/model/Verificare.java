package model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificare {
    private final Pattern pattern = Pattern.compile("([-+]?)(\\d*\\.?\\d*)?([x]\\^(-?\\d*))?");
    private Matcher m;
    private Polinom p = new Polinom();
    private Double coeficientFinal;
    private int exponentFinal;

    public void setP(Polinom p) {
        this.p = p;
    }

    public Polinom checkInput(String input) {
        m = pattern.matcher(input);
        while (m.find()) {
            String exponent = "";
            String coeficient = "";
            if (m.group(3) == null && m.group(4) == null) {
                if (!m.group(2).equals("") && !m.group(1).equals("")) {
                    coeficient = m.group(1) + m.group(2);
                    exponent = "0";
                }
                if (m.group(1).equals("") && m.group(2).equals("")) {
                    break;
                }
            }
            if (m.group(3) != null && m.group(4) != null) {
                if (!m.group(1).equals("") && m.group(2).equals("")) {
                    coeficient = "-1";
                    exponent = m.group(4);
                }
                if ((m.group(1).equals("") || m.group(1).equals("+")) && m.group(2).equals("")) {
                    coeficient = "1";
                    exponent = m.group(4);
                }
                if ((m.group(1).equals("+") || m.group(1).equals("")) && !m.group(2).equals("")) {
                    coeficient = m.group(1) + m.group(2);
                    exponent = m.group(4);
                }
                if (m.group(1).equals("-") && !m.group(2).equals("")) {
                    coeficient = m.group(1) + m.group(2);
                    exponent = m.group(4);
                }
            }
            parseToPoly(coeficient, exponent);
        }
        return p;
    }

    public void parseToPoly(String x, String y) {
        try {
            coeficientFinal = Double.parseDouble(x);
            exponentFinal = Integer.parseInt(y);
            p.addMonom(new Monom(coeficientFinal, exponentFinal));
        } catch (NumberFormatException e) {
            System.out.println("Wrong Input");
        }
    }
}
