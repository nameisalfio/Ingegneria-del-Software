//CONCRETE MEDIATOR
import java.util.ArrayList;
import java.util.List;

public class Chat implements ChatMediator {
    private List<IUser> users = new ArrayList<>();

    public Chat() {}

    @Override
    public void sendMessage(String message, IUser user) { //Tutti ricevono il messaggio, ad eccezione di chi lo ha inviato
        for (IUser u : users) {
            if (u != user)   
                u.receive(message);
        }
    }

    @Override
    public void addUser(IUser user) {   //Aggiunge utenti alla chat
        users.add(user);
    }
}
