import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        Fib obj = Fib.getIstances();
        Fib obj2 = Fib.getIstances();
        Fib obj3 = Fib.getIstances();
        Fib obj4 = Fib.getIstances();   //non verrà istanziato

        try
        {
            System.out.println("Value: " + obj.getValue(1));
            System.out.println("Value: " + obj2.getValue(5));
            System.out.println("Value: " + obj3.getValue(12));

        }
        catch(IOException e)
        {
            System.out.println("Overflow array\n" + e.getMessage());
        }
    }
}