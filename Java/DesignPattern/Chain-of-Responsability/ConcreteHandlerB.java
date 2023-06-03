//CONCRETE HANDLER2
public class ConcreteHandlerB implements Handler 
{
    private Handler nextHandler;

    public void setNextHandler(Handler handler) 
    {
        nextHandler = handler;
    }

    public void handleRequest(String request) 
    {
        if (request.equals("Richiesta B")) 
            System.out.println("La richiesta B è stata gestita dal ConcreteHandlerB");
        else 
        {
            if (nextHandler != null) 
                    nextHandler.handleRequest(request);
            else 
                System.out.println("Nessun ConcreteHandler può gestire la richiesta");
        }
    }
}