// CONCRETE COMMAND1

public class TurnOnLightCommand implements Command 
{
    private final Light light;  //receiver

    public TurnOnLightCommand(Light light) 
    {
        this.light = light;
    }

    @Override
    public void execute() 
    {
        light.turnOn();
    }
}