//MEDIATOR
public interface ChatMediator{

    void sendMessage(String message, IUser user);
    void addUser(IUser user);
}