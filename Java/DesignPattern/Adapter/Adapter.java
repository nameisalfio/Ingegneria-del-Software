//ADAPTER
class Adapter implements Target 
{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) 
    {
        this.adaptee = adaptee;
    }

    public String request(String username, String password) //la richiesta non si aspetta anche la quantità
    {
        return adaptee.specificRequest(username, password, adaptee.getAmount());
    }
}