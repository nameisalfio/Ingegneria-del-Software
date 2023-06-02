//CONCRETE IMPLEMENTOR2
public class DVDPlayer implements Device {

    @Override
    public void turnOn() {
        System.out.println("Lettore DVD acceso");
    }

    @Override
    public void turnOff() {
        System.out.println("Lettore DVD spento");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Non è possibile impostare il canale sul lettore DVD");
    }
}