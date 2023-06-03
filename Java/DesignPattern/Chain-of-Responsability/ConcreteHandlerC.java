//CONCRETE HANDLER3
public class ConcreteHandlerC implements Handler 
{
    private Handler nextHandler;

    public void setNextHandler(Handler handler) 
    {
        nextHandler = handler;
    }

    public void handleRequest(String request) 
    {
        if (request.equals("Richiesta C")) 
            System.out.println("La richiesta C è stata gestita dal ConcreteHandlerC");
        else 
        {
            if (nextHandler != null) 
                    nextHandler.handleRequest(request);
            else 
                System.out.println("Nessun ConcreteHandler può gestire la richiesta");
        }
    }
}