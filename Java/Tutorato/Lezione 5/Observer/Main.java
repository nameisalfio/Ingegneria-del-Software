public class Main {
    public static void main(String args[])
    {
        Hype hype = new Hype();

        Client a = new Client(0);
        Client b = new Client(1);

        hype.attach(a);
        hype.attach(b);

        hype.deposit(0, 10);
        hype.deposit(1, 15);

        hype.withdraw(0, 16);
        hype.withdraw(1, 10);

        hype.detach(b);
        hype.deposit(1, 10);

        hype.detach(b);
    }
}
