//CONCRETE DECORATOR

public class Pepperoni extends Topping {

    Pepperoni(Pizza wrappee) {
        super(wrappee);
    }

    public String getDescription(){
        return (wrappee.getDescription() + " + Peperoni");
    }

    public Double getCost(){
        return (wrappee.getCost() + 1.20);
    }
    
}
