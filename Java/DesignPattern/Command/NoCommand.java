// CONCRETE COMMAND3

public class NoCommand implements Command 
{
    @Override
    public void execute() 
    {
        System.out.println("Nothing");
    }
}