package model;

public class Operatii {

    public static Polinom add(Polinom p1, Polinom p2) {
        Polinom rez = new Polinom();
        int i = 0;
        int j = 0;
        while (i < p1.getMonomList().size() && j < p2.getMonomList().size()) {
            if (p1.getMonomList().get(i).getExponent() == p2.getMonomList().get(j).getExponent()) {
                rez.addMonom(new Monom(p1.getMonomList().get(i).getCoeficient() + p2.getMonomList().get(j).getCoeficient(), p1.getMonomList().get(i).getExponent()));
                i++;
                j++;
            } else if (p1.getMonomList().get(i).getExponent() > p2.getMonomList().get(j).getExponent()) {
                rez.addMonom(new Monom(p1.getMonomList().get(i).getCoeficient(), p1.getMonomList().get(i).getExponent()));
                i++;
            } else {
                rez.addMonom(new Monom(p2.getMonomList().get(j).getCoeficient(), p2.getMonomList().get(j).getExponent()));
                j++;
            }
        }
        while (i < p1.getMonomList().size()) {
            rez.addMonom(new Monom(p1.getMonomList().get(i).getCoeficient(), p1.getMonomList().get(i).getExponent()));
            i++;
        }
        while (j < p2.getMonomList().size()) {
            rez.addMonom(new Monom(p2.getMonomList().get(j).getCoeficient(), p2.getMonomList().get(j).getExponent()));
            j++;
        }
        return rez;
    }

    public static Polinom subtract(Polinom p1, Polinom p2) {
        Polinom rez = new Polinom();
        int i = 0;
        int j = 0;
        while (i < p1.getMonomList().size() && j < p2.getMonomList().size()) {
            if (p1.getMonomList().get(i).getExponent() == p2.getMonomList().get(j).getExponent()) {
                if (p1.getMonomList().get(i).getCoeficient() - p2.getMonomList().get(j).getCoeficient() == 0) {
                    i++;
                    j++;
                } else {

                    rez.addMonom(new Monom(p1.getMonomList().get(i).getCoeficient() - p2.getMonomList().get(j).getCoeficient(), p1.getMonomList().get(i).getExponent()));
                    i++;
                    j++;
                }
            } else if (p1.getMonomList().get(i).getExponent() > p2.getMonomList().get(j).getExponent()) {
                rez.addMonom(new Monom(p1.getMonomList().get(i).getCoeficient(), p1.getMonomList().get(i).getExponent()));
                i++;
            } else {
                rez.addMonom(new Monom(-p2.getMonomList().get(j).getCoeficient(), p2.getMonomList().get(j).getExponent()));
                j++;
            }
        }
        while (i < p1.getMonomList().size()) {
            rez.addMonom(new Monom(p1.getMonomList().get(i).getCoeficient(), p1.getMonomList().get(i).getExponent()));
            i++;
        }
        while (j < p2.getMonomList().size()) {
            rez.addMonom(new Monom(-p2.getMonomList().get(j).getCoeficient(), p2.getMonomList().get(j).getExponent()));
            j++;
        }
        return rez;
    }

    public static Polinom derivate(Polinom p) {
        Polinom rez = new Polinom();
        for (Monom m : p.getMonomList()) {
            rez.addMonom(new Monom(m.getCoeficient() * m.getExponent(), m.getExponent() - 1));
        }
        return rez;
    }

    public static Polinom integrate(Polinom p1) {
        Polinom rez = new Polinom();
        for (Monom m : p1.getMonomList()) {
            rez.addMonom(new Monom(m.getCoeficient() / (m.getExponent() + 1), m.getExponent() + 1));
        }
        return rez;
    }

    public static Polinom multiplication(Polinom first, Polinom second) {
        Polinom rez = new Polinom();
        for (Monom i : first.getMonomList()) {
            for (Monom j : second.getMonomList()) {
                rez.addMonom(new Monom(i.getCoeficient() * j.getCoeficient(), i.getExponent() + j.getExponent()));
            }
        }
        return rez;
    }

    public static String divide(Polinom p1, Polinom p2) {
        if (p1.getMonomList().get(0).getExponent() >= p2.getMonomList().get(0).getExponent()) {
            return realDivision(p1, p2);
        } else {
            return realDivision(p2, p1);
        }
    }

    private static String realDivision(Polinom p1, Polinom p2) {
        if (!p2.getMonomList().isEmpty()) {
            Polinom quot = new Polinom();
            Polinom rem = p1;
            Monom leadR = rem.getMonomList().get(0);
            Monom leadP2 = p2.getMonomList().get(0);
            while (leadR.getExponent() >= leadP2.getExponent()) {
                Polinom term = new Polinom();
                double termCoef = leadR.getCoeficient() / leadP2.getCoeficient();
                int termExponent = leadR.getExponent() - leadP2.getExponent();
                term.addMonom(new Monom(termCoef, termExponent));
                quot = add(quot, term);
                Polinom x = Operatii.multiplication(term, p2);
                rem = Operatii.subtract(rem, x);
                leadR = rem.getMonomList().get(0);
            }
            return "Cat: " + quot.toString() + "\t Rest: " + rem.toString();
        } else {
            return "Nu se poate imparti cu 0!";
        }
    }

}
