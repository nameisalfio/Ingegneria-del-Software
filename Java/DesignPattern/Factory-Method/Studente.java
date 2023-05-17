import java.util.ArrayList;
import java.util.List;

public class Studente implements IStudente
{
    private List<Esame> esami = new ArrayList<>();

    public void nuovoEsame(String m, int v)
    {
        Esame e = new Esame(m, v);
        esami.add(e);
    }

    public float getMedia()
    {
        if(esami.isEmpty())return 0;
        float sum = 0;
        for(Esame e : esami) sum += e.getVoto();
        return sum/esami.size();
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Esami sostenuti:\n\n");
        for (Esame e : esami) 
            sb.append(e.toString()).append("\n");

        return sb.append("\nMedia: ").append(getMedia()).toString();
    }
}