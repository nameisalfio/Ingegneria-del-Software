package Java.Singleton;

//Main
public class Main 
{
    public static void main(String[] args) 
    {
        Logs logs = Logs.getIstance();

        // Aggiunge alcuni dati al registro
        logs.insert("Primo messaggio di log");
        logs.insert("Secondo messaggio di log");
        logs.insert("Terzo messaggio di log");

        // Stampa l'ultimo messaggio di log
        System.out.println("\nUltimo messaggio di log: " + logs.getLast());

        // Stampa tutti i messaggi di log
        System.out.println("Tutti i messaggi di log:");
        System.out.println(logs.getAll());

        // Svuota la lista dei messaggi di log
        logs.empty();

    }
}

