public class ConcreteCommand2 implements Command{

    private Receiver receiver;

    ConcreteCommand2(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.action(this);
    }
    
}
