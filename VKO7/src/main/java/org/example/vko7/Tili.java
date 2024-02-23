package org.example.vko7;

import java.io.Serializable;
import java.util.Date;
import java.io.*;
public class Tili implements Serializable {
    /*
    Luodaan pyydetyt alustajat, ja get ja set metodit
    Tarkkana että ei sotke int ja double tyyppejä keskenään
     */
    private int id = 0;
    public int get_id(){
        return id;}
    public void set_id(int asetus){
        id = asetus;}
    private double saldo = 0;
    public double get_saldo(){
        return saldo;}
    public void set_saldo(double asetus){
        saldo = asetus;}
    // Static koska sanottiin että korko olisi yhteinen
    private static double vuosiKorko = 5;

    public static double getVuosiKorko() {
        return vuosiKorko;
    }
    public void set_vuosiKorko (double asetus){
        vuosiKorko = asetus;}
    //Alla Date on saatu importatusta .util.date
    private Date luontiPaiva;
    public Date get_luontiPaiva(){
        return luontiPaiva;
    }
    /*
     korko annetaan ohjelmalle jo prosentteina, eli pitää jakaa myös sadalla (4.5% = 0.045)
     ja kuukausi korko saadaan kun jaetaan 0.045/12
     */

    public double getKuukausiKorkoProsentti(){
        return ((vuosiKorko/100)/12);
    }
    //Käytetään hyväksi valmista metodia laskemaan koron antama summa kuukaudessa
    public double getKuukausiKorko(){
        return (saldo*getKuukausiKorkoProsentti());
    }
    // nos ja talletus metodit, ei mitään erikoista
    public void nosta(double nosto){
        saldo = saldo - nosto;
    }
    public void talleta(double talletus){
        saldo = saldo + talletus;
    }
    /*
    alustajissa on se että this.luontiPaiva = new Date(); luo tili olion sisälle aika olion.
    this() tekee siitä yksilöllisen juuri sille tili oliolle
     */
    public Tili(){
        id = 0;
        saldo = 0;
        vuosiKorko = 0;
        this.luontiPaiva = new Date();

    }
    public Tili(int tilinro,int saldo_){
        id = tilinro;
        saldo = saldo_;
        this.luontiPaiva = new Date();


    }

}