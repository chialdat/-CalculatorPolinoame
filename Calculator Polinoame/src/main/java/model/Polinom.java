package model;

import java.util.*;

public class Polinom {
    private List<Monom> monomList = new ArrayList<Monom>();

    public List<Monom> getMonomList(){
        return monomList;
    }

    public void addMonom(Monom monom) {
        for (Monom m : monomList) {
            if (m.getExponent() == monom.getExponent()) {
                m.setCoeficient(m.getCoeficient() + monom.getCoeficient());
                return;
            }
        }
        monomList.add(monom);
    }


    public String toString() {
        String s = "";
        for (Monom m : monomList) {
            s = s + m.toString();
        }
        return s;
    }
}
