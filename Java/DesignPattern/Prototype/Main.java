//CLIENT
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) 
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        ConcretePrototype prototype = new ConcretePrototype("Field1", 123, list);

        // Clonazione del prototipo
        ConcretePrototype clone = (ConcretePrototype) prototype.clone();

        // Modifica del campo field1 del clone
        clone.setField3(new ArrayList<Integer>());
        clone.getField3().add(4);
        clone.getField3().add(5);
        clone.getField3().add(6);

        // Stampa dei valori del prototipo e del clone
        System.out.println("Prototype: " + prototype.getField1() + ", " + prototype.getField2() + ", " + prototype.getField3());
        System.out.println("Clone: " + clone.getField1() + ", " + clone.getField2() + ", " + clone.getField3());
    }
}