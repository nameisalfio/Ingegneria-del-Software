//CLIENT
public class Client
{
    public static void main(String[] args) 
    {
        Adaptee adaptee = new Adaptee(180.56);
        Target target = new Adapter(adaptee);

        String outcome = target.request("MarioRossi", "password123");
        System.out.println(outcome);
    }
}