    package controller;

    import model.Operatii;
    import model.Polinom;
    import model.Verificare;
    import view.DashboardView;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class Controller {
        private DashboardView dashboardView;
        private String firstInput = "";
        private String secondInput = "";
        private Verificare regex1 = new Verificare();
        private Verificare regex2 = new Verificare();

        public Controller(DashboardView x){
                this.dashboardView = x;

                this.dashboardView.addButtonListener(new ActionListener() {
                    Polinom rez = new Polinom();

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        firstInput = dashboardView.getFirstText();;
                        secondInput = dashboardView.getSecondText();
                        rez = Operatii.add(regex1.checkInput(firstInput), regex2.checkInput(secondInput));
                        dashboardView.setResultLabel(rez.toString());
                        regex1.setP(new Polinom());
                        regex2.setP(new Polinom());
                    }
                });

            this.dashboardView.subtractButtonListener(new ActionListener() {
                Polinom rez = new Polinom();

                @Override
                public void actionPerformed(ActionEvent e) {
                    firstInput = dashboardView.getFirstText();;
                    secondInput = dashboardView.getSecondText();
                    rez = Operatii.subtract(regex1.checkInput(firstInput), regex2.checkInput(secondInput));
                    dashboardView.setResultLabel(rez.toString());
                    regex1.setP(new Polinom());
                    regex2.setP(new Polinom());
                }
            });

            this.dashboardView.multiplyButtonListener(new ActionListener() {
                Polinom rez = new Polinom();

                @Override
                public void actionPerformed(ActionEvent e) {
                    firstInput = dashboardView.getFirstText();;
                    secondInput = dashboardView.getSecondText();
                    rez = Operatii.multiplication(regex1.checkInput(firstInput), regex2.checkInput(secondInput));
                    dashboardView.setResultLabel(rez.toString());
                    regex1.setP(new Polinom());
                    regex2.setP(new Polinom());
                }
            });

            this.dashboardView.divisionButtonListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {
                    firstInput = dashboardView.getFirstText();;
                    secondInput = dashboardView.getSecondText();
                    dashboardView.setResultLabel(Operatii.divide(regex1.checkInput(firstInput), regex2.checkInput(secondInput)));
                    regex1.setP(new Polinom());
                    regex2.setP(new Polinom());
                }
            });

            this.dashboardView.integrationButtonListener(new ActionListener() {
                Polinom rez = new Polinom();

                @Override
                public void actionPerformed(ActionEvent e) {
                    firstInput = dashboardView.getFirstText();;
                    secondInput = dashboardView.getSecondText();
                    rez = Operatii.integrate(regex1.checkInput(firstInput));
                    dashboardView.setResultLabel(rez.toString());
                    regex1.setP(new Polinom());
                    regex2.setP(new Polinom());
                }
            });

            this.dashboardView.derivateButtonListener(new ActionListener() {
                Polinom rez = new Polinom();

                @Override
                public void actionPerformed(ActionEvent e) {
                    firstInput = dashboardView.getFirstText();;
                    secondInput = dashboardView.getSecondText();
                    rez = Operatii.derivate(regex1.checkInput(firstInput));
                    dashboardView.setResultLabel(rez.toString());
                    regex1.setP(new Polinom());
                    regex2.setP(new Polinom());
                }
            });
        }

    }
