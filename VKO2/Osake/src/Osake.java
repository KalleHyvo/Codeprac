public class Osake {
    /* Luodaan kentät
    Kaikki kentät ovat tyhjä ja julkisia, koska en jaksa vääntää get ja set metodeja :)
     */
    public String symboli;

    public String nimi;

    public double edellinenHinta;

    public double nykyinenhinta;

    //Alustaja jossa parametreina symboli (symbol) ja nimi (name)
    public Osake(String symbol, String name){
        //annetaan osake oliolle jo nimi ja symboli
        symboli = symbol;
        nimi = name;
    }
    public double getMuutosProsentti(){
       double muutos = ((nykyinenhinta-edellinenHinta)*100)/34.5;
       return muutos;
    }

}
