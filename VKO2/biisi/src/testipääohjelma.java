public class testipääohjelma {
    public static void main(String[] args){
        // Luodaan olio, ja sitten annetaan sille tietoja (Biisin nimi, esittjän nimi ja spotifymäärä)
        // lopuksi printataan olion tiedot
        // Olio1
        biisi Olio1 = new biisi();
             Olio1.uusi_nimi("Olavin Yodle"); Olio1.uusi_esittaja("Olavi"); Olio1.uusi_spotifySoittomaara(3);
            System.out.println("Tämä on olio1:"); //
            System.out.println("Biisin nimi: "+Olio1.get_nimi()+ " Esittäjän nimi: "+Olio1.get_esittaja()
            + " Spotifysoittamäärä: "+Olio1.get_spotifySoittomaara());
        // Olio 2
        biisi Olio2 = new biisi();
            Olio2.uusi_nimi("Bardin balladi"); Olio2.uusi_esittaja("Bardi"); Olio2.uusi_spotifySoittomaara(10);
            System.out.println("Tämä on olio3:");
            System.out.println("Biisin nimi: "+Olio2.get_nimi()+ " Esittäjän nimi: "+Olio2.get_esittaja() +
                    " Spotifysoittamäärä: "+Olio2.get_spotifySoittomaara());
        // Olio3
        biisi Olio3 = new biisi();
            Olio3.uusi_nimi("Hallelujah"); Olio3.uusi_esittaja("Lordi"); Olio3.uusi_spotifySoittomaara(100);
            System.out.println("Tämä on olio3:");
            System.out.println("Biisin nimi: "+Olio3.get_nimi()+ " Esittäjän nimi: "+Olio3.get_esittaja() +
                " Soittomäärä: "+Olio3.get_spotifySoittomaara());

    }
}
