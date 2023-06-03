//CONCRETE PROTOTYPE
import java.util.ArrayList;

public class ConcretePrototype implements Prototype 
{

    private String field1;
    private int field2;
    private ArrayList<Integer> field3;

    public ConcretePrototype(String field1, int field2, ArrayList<Integer> field3) 
    {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public ConcretePrototype(ConcretePrototype prototype) 
    {
        this.field1 = prototype.field1;
        this.field2 = prototype.field2;

        this.field3 = new ArrayList<Integer>();
        for (Integer element : prototype.field3) 
            this.field3.add(element);
    }

    public Prototype clone() 
    {
        return new ConcretePrototype(this);
    }

    //Getter e Setter

    public String getField1() 
    {
        return this.field1;
    }

    public int getField2() 
    {
        return this.field2;
    }

    public ArrayList<Integer> getField3() 
    {
        return this.field3;
    }

    public void setField3(ArrayList<Integer> field3) 
    {
        this.field3 = field3;
    }
}