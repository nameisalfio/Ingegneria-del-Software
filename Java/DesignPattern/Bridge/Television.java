//CONCRETE IMPLEMENTOR1
public class Television implements Device {

    @Override
    public void turnOn() {
        System.out.println("TV accesa");
    }

    @Override
    public void turnOff() {
        System.out.println("TV spenta");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Canale TV impostato su " + channel);
    }
}