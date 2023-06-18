public class Client {

    private static Receiver receiver = new Receiver();
    private static Invoker invoker = new Invoker();
    public static void main(String[] args) {

        Command command1 = new ConcreteCommand1(receiver);
        Command command2 = new ConcreteCommand2(receiver);
        
        // Esecuzione del primo comando
        invoker.setCommand(command1);
        invoker.executeCommand();
        
        // Esecuzione del secondo comando
        invoker.setCommand(command2);
        invoker.executeCommand();
    }
}
