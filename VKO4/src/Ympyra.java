import java.io.Serializable;
import java.io.*;

public class Ympyra implements Serializable {
    private double sade;
    public Ympyra(double r) {
        sade = r;
    }
    public double getAla() {
        return Math.PI * sade * sade;
    }
    public double getSade() {
        return sade;
    }
    public String toString() {
        return "Ympyr�n s�de on " + sade + " ja pinta-ala on " + getAla();
    }
    public boolean equals(Ympyra y) {
        if (this.sade == y.getSade())
            return true;
        else
            return false;
    }
    public boolean suurempiKuin(Ympyra y) {
        if (this.getAla() > y.getAla())
            return true;
        else
            return false;
    }
    public static void main (String[]args) throws IOException {
        Ympyra[] Taulu = new Ympyra[10];

        for(int i = 0; i < Taulu.length; i++){
            Taulu[i] = new Ympyra(i);
            System.out.println(Taulu[i]);}

        FileOutputStream YmpyraIn = new FileOutputStream("Ympyra.dat");


        ObjectOutputStream In = new ObjectOutputStream(YmpyraIn);

        for(int i = 0; i < Taulu.length; i++){
                In.writeObject(Taulu[i]);
            }
        In.close();
        YmpyraIn.close();
    }
}