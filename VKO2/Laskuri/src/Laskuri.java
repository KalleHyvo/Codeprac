//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Laskuri {
    public int luku1, luku2;
    public String s1;
    public int kerro() {
        int tulo = luku1 * luku2;
        return tulo;
    }
    //alustaja (parametriton)
    public Laskuri(){
    luku1 = 0;
    luku2 = 0;
    }
    /*Parametrinen alustaja, käyttää muuttujia abc joilla muutetaan luku1, luku2 ja s1 arvot
    this.s1 tarkoittaa että vain olion sisäinen s1 muutetaan, Laskuri luokan s1 pysyy samana
     */
    public Laskuri(int a, int b, String c){
    luku1 = a;
    luku2 = b;
    this.s1 = c;
    }


}