public class ConcreteCreator extends StCreator
{
    private static String type;

    public static IStudente getStudente(String type)
    {
        if(type.equalsIgnoreCase("Studente"))
        {
            System.out.println("\n...Factoring di un'oggetto di tipo " + type + "...\n");
            return new Studente();
        }

        if(type.equalsIgnoreCase("Sospeso"))
        {
            System.out.println("\n...Factoring di un'oggetto di tipo " + type + "...\n");
            return new Sospeso(0.0f);
        }
        else
        {
            System.out.println("Non è possibile istanziare nessun oggetto!\n");
            return null;
        }
    }

}