import java.io.*;
import java.util.*;

public class Pagamenti 
{
    private List<String> importi = new ArrayList<>();
    private float totale, massimo;

    // Potrebbe sollevare un'eccezzione
    public void leggiFile(String c, String n) throws IOException
    {
        LineNumberReader f = new LineNumberReader(new FileReader(new File(c, n)));
        while(true)
        {
            final String riga = f.readLine();
            if(null == riga) break;
            inserisci(riga);
        }
        f.close();
    }

    public void inserisci(String riga)
    {
        if(!importi.contains(riga))
            importi.add(riga);
    }

    /*public void calcolaSomma()
    {
        totale = 0;
        for(String v : importi)
            totale += Float.parseFloat(v);
    }*/

    public void calcolaSomma() {
        totale = 0;
        for (String v : importi) {
            String[] numeri = v.split(" "); // dividi la stringa in una matrice di stringhe
            for (String n : numeri) {
                totale += Float.parseFloat(n); // converte ogni elemento della matrice in float e somma il risultato alla variabile totale
            }
        }
    }

    /*public void CalcolaMassimo()
    {
        massimo = 0;
        for(String v : importi)
            if(massimo < Float.parseFloat(v))
                massimo = Float.parseFloat(v);
    }*/

    public void CalcolaMassimo()
    {
        massimo = 0;
        for(String v : importi) {
            String[] numeri = v.split(" ");
            for(String n : numeri) {
                float numero = Float.parseFloat(n);
                if(massimo < numero) {
                    massimo = numero;
                }
            }
        }
    }

    public void svuota()
    {
        importi = new ArrayList<>();
        totale = massimo = 0;
    }

    public float getMassimo(){return massimo;}

    public float getSomma(){return totale;}

    public static void main(String[] args)
    {
        final Pagamenti p = new Pagamenti();

        try
        {
            p.leggiFile("/home/alfiospoto/Scrivania/Anno 22-23 Università-DMI/Ingegneria del Software/Lista/", "file.txt");
        }
        catch(IOException e)
        {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }

        p.calcolaSomma();
        p.CalcolaMassimo();
        float somma = p.getSomma();
        System.out.println("Somma = " + somma);
    }
}
