// INVOKER

public class RemoteControl 
{
    private final Command[] onCommands;
    private final Command[] offCommands;

    public RemoteControl() 
    {
        int numCommands = 10;
        onCommands = new Command[numCommands];
        offCommands = new Command[numCommands];

        for (int i = 0; i < numCommands; i++) 
        {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) 
    {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOnButton(int slot) //execute
    {
        onCommands[slot].execute();
    }

    public void pressOffButton(int slot)    //execute
    {
        offCommands[slot].execute();
    }
}