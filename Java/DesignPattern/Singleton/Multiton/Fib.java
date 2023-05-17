import java.io.IOException;

public class Fib
{
    private static Fib istance;
    private int x[] = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
    private static int numIstance = 1;

    private Fib()
    {
        System.out.println("Istance n°" + numIstance);
        numIstance ++;
    }

    public static Fib getIstances()
    {
        if(numIstance <= 3)
        {
            istance = new Fib();
            return istance;
        }
        return null;
    }

    public int getValue(int idx) throws IOException
    {
        if(idx < 10)
            return x[idx-1];
        else 
            return 0;
    }
}