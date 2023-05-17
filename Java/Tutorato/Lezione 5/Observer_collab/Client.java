public class Client implements Observer{    //concrete observer

    private final String name;

    Client(String name){
        this.name = name;
    }

    @Override
    public void update(Subject subject, Object state){
        if(subject instanceof Market m)
            System.out.println("Client ( " + name + " ) " + state);
    }
}