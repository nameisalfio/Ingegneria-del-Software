// CLIENT
public class Client 
{
    public static void main(String[] args) 
    {
        Light light = new Light();  //Receiver

        Command turnOnCommand = new TurnOnLightCommand(light);  //C.Command1
        Command turnOffCommand = new TurnOffLightCommand(light);    //C.Command2

        RemoteControl remoteControl = new RemoteControl();  //Invoker
        remoteControl.setCommand(0, turnOnCommand, turnOffCommand);

        // Press the on button
        System.out.println("Accendo la luce...");
        remoteControl.pressOnButton(0);

        System.out.println("");

        // Press the off button
        System.out.println("Spengo la luce...");
        remoteControl.pressOffButton(0);
    }
}