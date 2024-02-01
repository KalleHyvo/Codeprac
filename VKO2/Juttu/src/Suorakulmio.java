public class Suorakulmio{
    //vaaditut kentätä
    double leveys = 1;
    double korkeus = 1;
    public Suorakulmio(){
        //oletussuorakulmion alustaja, oletus mitat
        leveys = 1;
        korkeus = 1;
    }
    public Suorakulmio(double L, double K){
        /*
        Luo olion jonka leveys ja korkeus voidaan päättää
         */
        this.leveys = L;
        this.korkeus = K;


    }
    public double getAla(){
        //pinta-ala laskuja
        return leveys * korkeus;
    }
    public double getYmparys(){
        //ympärys laskuja
        return ((2*leveys) + (2*korkeus));
    }
}