//CONCRETE STATE 1
class StateOff implements State 
{
    public void handle(Switch context) 
    {
        System.out.println("Off");
        context.setState(new StateOn());
    }
}