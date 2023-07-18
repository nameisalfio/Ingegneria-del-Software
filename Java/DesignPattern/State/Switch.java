//CONTEXT
class Switch
{
    private State state;

    public Switch() 
    {
        this.state = new StateOff();
    }

    public void setState(State state) 
    {
        this.state = state;
    }

    public void pressButton() // request
    {
        state.handle(this);
    }
}