public class Persona 
{
    private String nome;
    private int eta;
    private String impiego;

    Persona(String nome, int eta, String impiego)
    {
        this.nome = nome;
        this.eta = eta;
        this.impiego = impiego;
    }

    String getNome()
    {
        return this.nome;
    }

    String getImpiego()
    {
        return this.impiego;
    }


    int getEta()
    {
        return this.eta;
    }

}   
