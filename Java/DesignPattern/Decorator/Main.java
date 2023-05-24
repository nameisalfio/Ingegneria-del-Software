public class Main {
    public static void main(String[] args) {

        // Pizza base
        Pizza pizza = new Margherita(); 

        // Applicazione dei decorator
        pizza = new Cheese(new Mushrooms(new Pepperoni(pizza)));    // Fluent : interfaccia fissa e invocazioni in cascata (Refactoring)

        System.out.println(pizza.getDescription());
        System.out.println("Costo totale: € " + pizza.getCost());
    }
}