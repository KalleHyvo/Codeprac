public class pääohjelma {
    public static void main(String[] args){
        //Luodaan olio Laskin ja annetaan pyydetyt tiedot (käytetään parametristä alustajaa)
        Laskuri Laskin = new Laskuri(23, 29,"Moikka");
        //Printataan Olion tiedot
        System.out.println("Laskin olio: luku1 ="+ Laskin.luku1+" Luku2 = "+ Laskin.luku2+
                " s1 = "+ Laskin.s1);
        /** tässä printtaan kerro() metodin palauttaman tiedon ja s1 kentän samalla.
         s1 on sama kuin Laskin oliossa, tai sitten piti tulostaa Laskuri luokan s1 kenttä.
        Laksuri luokan s1 kenttä antaa null, joten oletan että Olion s1 kenttä pitää tulostaa

         Kuitenkin laskuri Luokan kentän saisi tällä koodilla:

         Laskuri Laskin2 = new Laskuri();
         System.out.println(Laskin2.s1);
         */

        System.out.println("Kerro metodi ="+Laskin.kerro()+", s1 = "+ Laskin.s1);

    }
}
