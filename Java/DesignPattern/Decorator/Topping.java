//DECORATOR

public abstract class Topping implements Pizza{

    protected Pizza wrappee;

    Topping(Pizza wrappee){
        this.wrappee = wrappee;
    }

    public String getDescription(){
        return wrappee.getDescription();
    }

    public Double getCost(){
        return wrappee.getCost();
    }   
}