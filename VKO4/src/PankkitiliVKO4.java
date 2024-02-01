import java.util.Scanner;
import java.io.*;

public class PankkitiliVKO4 implements Serializable {
    // Tarvitaan näitä kenttiä jotta voidaan varastoida taulukon indeksi ja valitun tilin id
    // käytän nimitystä "valinta kentät"
    public static int valinta_id;
    public static int valinta_indeksi;

    // Tämä metodi on tehty sen takia että vaihtoehtojen printtaus olisi yksinkertaista
    public static void valinta_show() {
        System.out.println(1 + " Tarkista saldo \n" +
                2 + " Rahan nosto \n" +
                3 + " Rahan talletus \n" +
                4 + " Toinen tili \n" +
                5 + " Poistu");
    }

    public static void main(String[] args) throws IOException {
        try {
            FileInputStream TiliOut = new FileInputStream("tilit.dat");
            ObjectInputStream Out = new ObjectInputStream(TiliOut);
            System.out.println("Tiedosto löytyi!" + "\n");
            Tili[] Taulu = new Tili[10];
            for (int i = 0; i < Taulu.length; i++) {
                Tili Kopio = null;
                Kopio = (Tili) Out.readObject();
                Taulu[i] = Kopio;
            }
            Out.close();
            TiliOut.close();
            Scanner User_input = new Scanner(System.in);
            //ID valinnat näytölle
            for (int i = 0; i < Taulu.length; i++) {
                try {
                    System.out.println("Tili " + i + " ID: " + Taulu[i].get_id());
                } catch (Exception e) {
                    break;
                }
            }
            //Kysytään mitä tiliä halutaan tarkistella, ja scanneri sitten ottaa vastaan käyttäjän inputin
            System.out.println("Haluttu tilin id: ");
            int Wanted_id = User_input.nextInt();
            //koko jutun juju on että tätä silmukkaa käydään niin kauan, kunne käyttäjä manuaalisesti poistuu siitä
            while (true) {


                for (int i = 0; i < Taulu.length; i++) {
                    if (Wanted_id == Taulu[i].get_id()) {
                        valinta_id = Wanted_id;
                        valinta_indeksi = i;
                        break;
                    }
                }
                //näytetään valinnat
                valinta_show();
                //lisää käyttäjän inputtia
                int Wanted_option = User_input.nextInt();
                //tässä on sitten if/ else if ehtoja joista tulee tiettyjä tapahtumia valinta_show(); mukaisesti
                if (Wanted_option == 1) {
                    System.out.println("Saldo on: " + Taulu[valinta_indeksi].get_saldo() + "\n");
                } else if (Wanted_option == 2) {
                    System.out.println("Noston määrä: ");
                    int Wanted_money = User_input.nextInt();
                    Taulu[valinta_indeksi].nosta(Wanted_money);
                } else if (Wanted_option == 3) {
                    System.out.println("Talletuksen määrä: ");
                    int Wanted_money = User_input.nextInt();
                    Taulu[valinta_indeksi].talleta(Wanted_money);
                } else if (Wanted_option == 4) {
                    //ID valinnat näytölle
                    for (int i = 0; i < Taulu.length; i++) {
                        try {
                            System.out.println("Tili " + i + " ID: " + Taulu[i].get_id());
                        } catch (Exception e) {
                            break;
                        }
                    }
                    System.out.println("Haluttu tilin id: ");
                    int newWanted_id = User_input.nextInt();


                    for (int i = 0; i < Taulu.length; i++) {
                        if (newWanted_id == Taulu[i].get_id()) {
                            Wanted_id = newWanted_id;
                            break;
                        }
                    }



                } else if (Wanted_option == 5) {
                    FileOutputStream TilitIn = new FileOutputStream("tilit.dat");
                    ObjectOutputStream in = new ObjectOutputStream(TilitIn);
                    for(int h = 0; h < Taulu.length; h++){
                        in.writeObject(Taulu[h]);
                    }
                    in.close();
                    TilitIn.close();


                    break;}
                }

        }
        catch (ClassNotFoundException | IOException e) {
            System.out.println("Tiedostoa ei löytynyt!" + "\n");
            Tili[] Taulu = new Tili[10];
            Tili Tili1 = new Tili(20, 100);
            Tili Tili2 = new Tili(21, 100);
            Tili Tili3 = new Tili(22, 100);
            //taulun oliot
            Taulu[0] = Tili1;
            Taulu[1] = Tili2;
            Taulu[2] = Tili3;

            Scanner User_input = new Scanner(System.in);
            //ID valinnat näytölle
            for (int i = 0; i < Taulu.length; i++) {
                try {
                    System.out.println("Tili " + i + " ID: " + Taulu[i].get_id());
                } catch (Exception k) {
                    break;
                }
            }
            //Kysytään mitä tiliä halutaan tarkistella, ja scanneri sitten ottaa vastaan käyttäjän inputin
            System.out.println("Haluttu tilin id: ");
            int Wanted_id = User_input.nextInt();
            //koko jutun juju on että tätä silmukkaa käydään niin kauan, kunne käyttäjä manuaalisesti poistuu siitä
            while (true) {

                for (int i = 0; i < Taulu.length; i++) {
                    if (Wanted_id == Taulu[i].get_id()) {
                        valinta_id = Wanted_id;
                        valinta_indeksi = i;
                        break;
                    }
                }
                //näytetään valinnat
                valinta_show();
                //lisää käyttäjän inputtia
                int Wanted_option = User_input.nextInt();
                //tässä on sitten if/ else if ehtoja joista tulee tiettyjä tapahtumia valinta_show(); mukaisesti
                if (Wanted_option == 1) {
                    System.out.println("Saldo on: " + Taulu[valinta_indeksi].get_saldo() + "\n");
                } else if (Wanted_option == 2) {
                    System.out.println("Noston määrä: ");
                    int Wanted_money = User_input.nextInt();
                    Taulu[valinta_indeksi].nosta(Wanted_money);
                } else if (Wanted_option == 3) {
                    System.out.println("Talletuksen määrä: ");
                    int Wanted_money = User_input.nextInt();
                    Taulu[valinta_indeksi].talleta(Wanted_money);
                } else if (Wanted_option == 4) {
                    //ID valinnat näytölle
                    for (int i = 0; i < Taulu.length; i++) {
                        try {
                            System.out.println("Tili " + i + " ID: " + Taulu[i].get_id());
                        } catch (Exception k) {
                            break;
                        }
                    }
                    System.out.println("Haluttu tilin id: ");
                    int newWanted_id = User_input.nextInt();


                    for (int i = 0; i < Taulu.length; i++) {
                        if (newWanted_id == Taulu[i].get_id()) {
                            Wanted_id = newWanted_id;
                            break;
                        }
                    }



                } else if (Wanted_option == 5) {
                        FileOutputStream TilitIn = new FileOutputStream("tilit.dat");
                        ObjectOutputStream in = new ObjectOutputStream(TilitIn);
                        for(int h = 0; h < Taulu.length; h++){
                            in.writeObject(Taulu[h]);
                        }
                        in.close();
                        TilitIn.close();


                    break;}
                }
            }
        }
    }

