import java.io.*;
public class Lukija implements Serializable {
    public static void main (String [] args){
        try {
            FileInputStream YmpyraOut = new FileInputStream("Ympyra.dat");
            ObjectInputStream Out = new ObjectInputStream(YmpyraOut);
            Ympyra[] Taulu = new Ympyra[10];
            for(int i = 0; i < Taulu.length; i++ ){
                Ympyra Kopio  = null;
                Kopio = (Ympyra) Out.readObject();
                Taulu[i] = Kopio;
            }
            Out.close();
            YmpyraOut.close();
            for (int k = 0; k < Taulu.length; k++){
                System.out.println(Taulu[k]);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ei löytynyt");
        }

    }
}