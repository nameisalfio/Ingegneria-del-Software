import java.time.LocalDate;

class HelloWorld
{
    private static final String msg = "Lezione di ingegneria del Software";
    private static final LocalDate d = LocalDate.now();

    public static void main(String[] args)
    {
        System.out.println("Hello World");
        System.out.println(msg);
        System.out.println(d);
    }

}