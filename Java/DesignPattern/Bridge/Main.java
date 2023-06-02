public class Main {
    public static void main(String[] args) {

        Device television = new Television();   //concrete implementor
        RemoteControl remoteControl = new BasicRemoteControl(television);   //redefined abstraction

        remoteControl.powerOn();
        remoteControl.setChannel(5);
        remoteControl.powerOff();

        System.out.println();

        Device dvdPlayer = new DVDPlayer(); //concrete implementor
        remoteControl = new BasicRemoteControl(dvdPlayer);  //redefined abstraction

        remoteControl.powerOn();
        remoteControl.setChannel(7);
        remoteControl.powerOff();
    }
}