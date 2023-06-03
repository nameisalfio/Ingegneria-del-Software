//CONCRETE HANDLER1
public class ConcreteHandlerA implements Handler
{
    private Handler nextHandler;

    public void setNextHandler(Handler handler) 
    {
        nextHandler = handler;
    }

    public void handleRequest(String request) 
    {
        if (request.equals("Richiesta A")) 
            System.out.println("La richiesta A è stata gestita dal ConcreteHandlerA");
        else 
        {
            if (nextHandler != null) 
                    nextHandler.handleRequest(request);
            else 
                System.out.println("Nessun ConcreteHandler può gestire la richiesta");
        }
    }
}