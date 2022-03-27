package model;

public class Monom {
    private double coeficient;
    private int exponent;

    public Monom(double coeficient, int exponent){
        this.coeficient = coeficient;
        this.exponent = exponent;
    }


    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public String toString() {
        if (coeficient == 1 && exponent == 1)
            return "+x";
        if (coeficient > 0) {
            if (exponent == 1)
                return "+" + coeficient + "x";
            else if (exponent > 1) {
                if (coeficient == 1) {
                    return "+x^" + exponent;
                } else {
                    return "+" + coeficient + "x^" + exponent;
                }
            } else {
                if (exponent == 0) {
                    return "+" + coeficient;
                }
                return "+" + coeficient + "x^(" + exponent + ")";
            }
        } else if (coeficient < 0) {
            if (exponent == 1)
                if (coeficient == -1) {
                    return coeficient + "x";
                } else {
                    return coeficient + "*x";
                }
            if (exponent > 1) {
                return coeficient + "x^" + exponent;
            }
            if (exponent < 1) {
                if (exponent == 0) {
                    return coeficient + "";
                } else
                    return coeficient + "x^(" + exponent + ")";
            }
        }
        return "";
    }

}
