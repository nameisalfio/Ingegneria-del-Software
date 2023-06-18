public class Persona 
{
    private String nome;
    private int eta;

    Persona(String nome, int eta)
    {
        this.nome = nome;
        this.eta = eta;
    }

    String getNome()
    {
        return this.nome;
    }

    int getEta()
    {
        return this.eta;
    }

    static Persona getOlder(Persona a, Persona b)
    {
        return a.eta > b.eta ? a : b;
    }
}  
