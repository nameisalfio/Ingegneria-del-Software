//CONCRETE FACTORY 1

public class ModernFactory implements AbstractFactory 
{
    public Chair createChair()
    {
        return new ModernChair();
    }

    public Table createTable()
    {
        return new ModernTable();
    }
}
