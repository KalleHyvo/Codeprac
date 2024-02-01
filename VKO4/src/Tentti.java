/*
public class Tentti implements Erinomainen {
    private class Kirjoitelma{
        private double Kielioppi = 5;
        private double Oikeinkirjoitus = 10;
        private double Pituus = 20;
        private double Sisältö = 30;
        public double getKirjoitelmapoint(){
            return Kielioppi + Oikeinkirjoitus + Pituus + Sisältö;
        }

    }
    private double pisteet;

    public void setPisteet(double p){
        this.pisteet = p;
    }

    public double getPisteet(){
        return this.pisteet;
    }

    public int getArvosana(){
        int arvosana;

        if (this.pisteet >= 90) {
            arvosana = 5;
        }
        else if (this.pisteet >= 80) {
            arvosana = 4;
        }
        else if (this.pisteet >= 70) {
            arvosana = 3;
        }
        else if (this.pisteet >= 60) {
            arvosana = 2;
        }
        else if (this.pisteet >= 50) {
            arvosana = 1;
        }
        else {
            arvosana = 0;
        }
        return arvosana;
    }
    @Override
    public boolean onkoErinomainen(){
        return this.getArvosana() == 5;
    }
    public static void main (String[]args){
        Tentti Tentti = new Tentti();
        Tentti.Kirjoitelma Kirjoitelma1 = Tentti.new Kirjoitelma();
        Tentti.setPisteet(Kirjoitelma1.getKirjoitelmapoint());
        System.out.println("Arvosana on "+Tentti.getArvosana());
        System.out.println("Arvosana on 5: "+ Tentti.onkoErinomainen());
    }

}
 */
