//REDEFINED ABSTRACTION
class BasicRemoteControl extends RemoteControl {
    
    public BasicRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.println("Accensione del dispositivo remoto");
        device.turnOn();
    }

    @Override
    public void powerOff() {
        System.out.println("Spegnimento del dispositivo remoto");
        device.turnOff();
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Impostazione del canale " + channel + " sul dispositivo remoto");
        device.setChannel(channel);
    }
}