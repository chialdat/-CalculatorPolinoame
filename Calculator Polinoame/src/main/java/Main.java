import controller.Controller;
import model.Monom;
import model.Operatii;
import model.Polinom;
import model.Verificare;
import view.DashboardView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        DashboardView dashboardView = new DashboardView();
        dashboardView.setVisible(true);
        Controller c = new Controller(dashboardView);

        Monom m1 = new Monom(1, 3);
        Monom m2 = new Monom(-2, 2);
        Monom m3 = new Monom(6, 1);
        Monom m4 = new Monom(-5, 0);
        Polinom p1 = new Polinom();
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        p1.addMonom(m4);

        Monom m5 = new Monom(1, 2);
        Monom m6 = new Monom(-1, 0);
        Polinom p2 = new Polinom();
        p2.addMonom(m5);
        p2.addMonom(m6);

        System.out.println("Adunare");
        Polinom rez = Operatii.add(p1,p2);
        System.out.println(rez);

        System.out.println("Scadere");
        rez = Operatii.subtract(p1,p2);
        System.out.println(rez);

        System.out.println("Inmultire");
        rez = Operatii.multiplication(p1,p2);
        System.out.println(rez);



        System.out.println("Integrare");
        rez = Operatii.integrate(p2);
        System.out.println(rez);

        System.out.println("Derivare");
        rez = Operatii.derivate(p1);
        System.out.println(rez);

        System.out.println("Impartire");
        System.out.println(Operatii.divide(p1, p2));
        //System.out.println(rez);

        String a = "x^3+2x^2+1";
        Verificare t = new Verificare();
        Polinom x =  t.checkInput(a);
        System.out.println(x);
    }
}
