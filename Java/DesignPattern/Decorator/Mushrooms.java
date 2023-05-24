//CONCRETE DECORATOR

public class Mushrooms extends Topping {

    Mushrooms(Pizza wrappee) {
        super(wrappee);
    }

    public String getDescription(){
        return (wrappee.getDescription() + " + Funghi");
    }

    public Double getCost(){
        return (wrappee.getCost() + 0.80);
    }
    
}
