public class testiohjelma {
    public static void main(String[] arg){
        //Luodaan osake_olio, annetaan symboli NOK ja nimi Nokia OYJ
        Osake Osake_olio = new Osake("NOK", "Nokia OYJ");
        //Annetaan Osake_oliolle hinnat
        Osake_olio.edellinenHinta = 34.5;
        Osake_olio.nykyinenhinta = 34.35;
        // Osakkeen tiedot printti:
        System.out.println(Osake_olio.nimi+" ("+Osake_olio.symboli+")"
                +"\n"+"Eilen: "+ Osake_olio.edellinenHinta+" $" +"\n"+
                "Tänään: "+ Osake_olio.nykyinenhinta+ " $" + "\n"+
                "Hinnan muutos: "+ Osake_olio.getMuutosProsentti()+"%");

    }
}
