public class Tuuletin {
    //kentät, final koska vakio arvoja ei muuteta
    // vakiot "yhdessä" samalla rivillä helpon lukemisen takia
    final int HIDAS  = 1; final int NORMAALI = 2; final int NOPEA = 3;
    private int nopeus= HIDAS;
        public int get_nopeus(){
            return nopeus;}
        public void set_nopeus(int asetus){
            nopeus = asetus;}
    private boolean kytketty = false;
        public boolean get_kytketty(){
            return kytketty;}
        public void set_kytketty(boolean asetus){
            kytketty = asetus;}
    private double halkaisija = 5;
        public double get_halkaisija(){
            return halkaisija;}
        public void set_halkaisija( double asetus){
            halkaisija = asetus;}

    private String vari = "blue";
        public String get_vari(){
            return vari;}
        public void set_vari(String asetus){
            vari = asetus;}
    //alustus
    public Tuuletin(){
            
    }
    /*
    toString on valmiina funktio, nyt pitää vain antaa sille if-else joka katsoo onko
    kytketty true vai false, toString muuntaa kaikki palauttamansa stringiksi.
     */
   public String toString(){
            if (kytketty == true){
                return "Nopeus: "+get_nopeus()+ " Väri: "+get_vari()+ "Halkaisija: "+get_halkaisija();
            } else{
                return "Nopeus: "+get_nopeus()+ " Väri: "+get_vari()+ " Halkaisija: "+get_halkaisija()+"\n"
                        +"tuuletin ei ole päällä";


            }

    }

}
