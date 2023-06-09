//CONCRETE FACTORY 2

public class VictorianFactory implements AbstractFactory
{
    public Chair createChair()
    {
        return new VictorianChair();
    }

    public Table createTable()
    {
        return new VictorianTable();
    }
}
