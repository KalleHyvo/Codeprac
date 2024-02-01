public class testiohjelma {
    public static void main(String[] args){
        //luodaan olio Tili1, ja annetaan sille id ja saldo
        Tili Tili1 = new Tili(1122,20000);
        //korko oliolle
        Tili1.set_vuosiKorko(4.5);
        //kutsutaan nosta ja talleta metodi
        Tili1.nosta(2500);
        Tili1.talleta(3000);
        //Tulostetaan tiedot näytölle
        System.out.println("Tili"+": "+Tili1.get_id()+"\n"
        +"Saldo: "+Tili1.get_saldo()+"\n"+
                "Kuukausikorko: "+ Tili1.getKuukausiKorko()+"\n"+
                "Luotu: "+ Tili1.get_luontiPaiva());
    }

    
}
