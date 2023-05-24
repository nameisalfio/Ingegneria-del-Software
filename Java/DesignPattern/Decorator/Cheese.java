//CONCRETE DECORATOR

public class Cheese extends Topping {

    Cheese(Pizza wrappee) {
        super(wrappee);
    }

    public String getDescription(){
        return (wrappee.getDescription() + " + Formaggio extra");
    }

    public Double getCost(){
        return (wrappee.getCost() + 1.20);
    }
    
}
