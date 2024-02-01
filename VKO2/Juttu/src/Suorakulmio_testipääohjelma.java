public class Suorakulmio_testipääohjelma {


    public static void main(String[]args){
       //Luodaan Suorakuolmiot 1 ja 2
       Suorakulmio Suorakulmio1 = new Suorakulmio(4,40 );
       Suorakulmio Suorakulmio2 = new Suorakulmio(3.5, 35.9);
       // Tulostetaan mitat ja laskut olio kerrallaa, ensin Suorakulmio1
        System.out.println("Suorakulmio1"+"\n"+"Leveys: " +Suorakulmio1.leveys+
                "\n"+ "Korkeus: "+ Suorakulmio1.korkeus+"\n"+ "Pinta-ala: "+ Suorakulmio1.getAla()+
                "\n"+"Ympärys: " +Suorakulmio1.getYmparys());
        // Sama Suorakulmio2:
        System.out.println("Suorakulmio2"+"\n"+"Leveys: " +Suorakulmio2.leveys+
                "\n"+ "Korkeus: "+ Suorakulmio2.korkeus+"\n"+ "Pinta-ala: "+ Suorakulmio2.getAla()+
                "\n"+"Ympärys: " +Suorakulmio2.getYmparys());
    }


}
