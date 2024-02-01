public class testiohjelma {
    public static void main(String [] args){
        // Olio tuuletin1 ja sille nopeus, halkaisija jne
        Tuuletin Tuuletin1 = new Tuuletin();
            Tuuletin1.set_nopeus(3);
            Tuuletin1.set_halkaisija(10);
            Tuuletin1.set_vari("keltainen");
            Tuuletin1.set_kytketty(true);
        // Olio tuuletin2 ja sille nopeus jne
        Tuuletin Tuuletin2 = new Tuuletin();
            Tuuletin2.set_nopeus(2);
            Tuuletin2.set_halkaisija(5);
            Tuuletin2.set_vari("blue");
            Tuuletin2.set_kytketty(false);
        // Tulostetaan olioiden tiedot toString metodilla
        System.out.println(Tuuletin1.toString());
        System.out.println(Tuuletin2.toString());

    }
}
