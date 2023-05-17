import java.util.Random;

public class Main
{
    private static void fill(IStudente s)
    {
        Random random = new Random();
        String[] mat = {"Matematica", "Storia", "Geografia", "Italiano", "Scienze", "Inglese"};
        for(int i=0; i<10; i++)
            s.nuovoEsame(mat[random.nextInt(6)], random.nextInt(7) + 4);
    }
    public static void main(String[] args)
    {
        IStudente s = ConcreteCreator.getStudente("studente");
        Main.fill(s);
        System.out.println(s.toString());
    }
}