//CLIENT

public class Main 
{
    private static AbstractFactory factory;
    public static void main(String[] args) 
    {
        //Modern
        client(new ModernFactory());    

        //Victorian
        client(new VictorianFactory());        
    }   
    
    static void client(AbstractFactory f)
    {
        factory = f;
        Chair chair;
        Table table;

        chair = factory.createChair();
        table = factory.createTable();
        chair.sitOn();
        table.eatOn();
        System.out.println("");
    }
}
