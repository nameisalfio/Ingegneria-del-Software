
public class Sospeso implements IStudente
{
    private float media;

    public Sospeso(float m){media = m;}

    public void nuovoEsame(String m, int v)
    {
        System.out.println("Non è possibile sostenere esami");
    }

    public float getMedia(){return media;}

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Esami sostenuti = 0\n");
        return sb.append("\nMedia: ").append(getMedia()).toString();
    }
}