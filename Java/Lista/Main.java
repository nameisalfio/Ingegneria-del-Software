import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        final Pagamenti p = new Pagamenti();
    
        try
        {
            p.leggiFile("/home/alfiospoto/Scrivania/Anno 22-23 Università-DMI/Ingegneria-del-Software/Java/Lista", "file.txt");
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

