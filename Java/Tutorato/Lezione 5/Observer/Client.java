public class Client implements Observer{    //concrete observer
    private final int id;

    Client(int id){
        this.id = id;
    }

    @Override
    public void update(Subject sub){
        if(sub instanceof Hype h){
            System.out.println("Utente " + id + ". Saldo aggiornato a " + h.getBalance(id));
        }
    }

    public int getId(){
        return this.id;
    }
}