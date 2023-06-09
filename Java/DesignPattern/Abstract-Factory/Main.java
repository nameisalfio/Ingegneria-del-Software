//CLIENT

public class Main 
{
    private static AbstractFactory factory;
    public static void main(String[] args) 
    {
        Chair chair;
        Table table;

        //Modern
        factory = new ModernFactory();
        chair = factory.createChair();
        table = factory.createTable();
        chair.sitOn();
        table.eatOn();

        System.out.println("");

        //Victorian
        factory = new VictorianFactory();
        chair = factory.createChair();
        table = factory.createTable();
        chair.sitOn();
        table.eatOn();
    }    
}
