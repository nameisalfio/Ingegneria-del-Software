public class Persona 
{
    private String nome;
    private int eta;
    private String ruolo;

    Persona(String nome, int eta, String ruolo)
    {
        this.nome = nome;
        this.eta = eta;
        this.ruolo = ruolo;
    }

    String getNome()
    {
        return this.nome;
    }

    int getEta()
    {
        return this.eta;
    }

    String getRuolo()
    {
        return this.ruolo;
    }

}   
