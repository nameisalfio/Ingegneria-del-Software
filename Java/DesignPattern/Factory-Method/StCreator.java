public class StCreator
{
    private static float v = 0;

    protected static IStudente getStudente()
    {
        if(v == 0)  return new Studente();
        return new Sospeso(v);
    }
}