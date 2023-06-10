//ADAPTEE
class Adaptee 
{
    private double amount;

    Adaptee(double amount)
    {
        this.amount = amount;
    }

    public String specificRequest(String username, String password, double amount) 
    {
        // Autenticazione dell'utente
        if (!authenticate(username, password)) 
            return ("Autenticazione fallita per l'utente " + username);

        // Elaborazione della transazione
        if (!processPayment(amount)) 
            return ("Transazione fallita per l'utente " + username);

        return ("Transazione di " + amount + "$ eseguita con successo per l'utente " + username);
    }

    private boolean authenticate(String username, String password) 
    {
        // Logica di autenticazione dell'utente
        return true;
    }

    private boolean processPayment(double amount) 
    {
        // Logica di elaborazione della transazione
        return true;
    }

    double getAmount()
    {
        return this.amount;
    }
}