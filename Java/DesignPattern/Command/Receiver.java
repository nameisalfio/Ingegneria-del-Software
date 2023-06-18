public class Receiver {

    public void action(Command command){
        if(command instanceof ConcreteCommand1)
            specificAction1();
        if(command instanceof ConcreteCommand2)
            specificAction2();
    }

    public void specificAction1(){
        System.out.println("Specific action #1...");
    }

    public void specificAction2(){
        System.out.println("Specific action #2...");
    }
    
}
