//CONCRETE STATE 2
class StateOn implements State 
{
    public void handle(Switch context) 
    {
        System.out.println("On");
        context.setState(new StateOff());
    }
}