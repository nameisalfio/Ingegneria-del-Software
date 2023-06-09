// CONCRETE COMMAND2

public class TurnOffLightCommand implements Command 
{
    private final Light light;  //receiver

    public TurnOffLightCommand(Light light) 
    {
        this.light = light;
    }

    @Override
    public void execute() 
    {
        light.turnOff();
    }
}