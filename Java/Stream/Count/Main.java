import java.util.List;

class Main
{
    public static void main(String[] args) 
    {
        System.out.println();
        List<String> list = List.of("Alfio", "Pippo", "Flavio", "Vito", "Lele", "Pippo");
        long count = list.stream()
                         .filter(s->s.equalsIgnoreCase("Pippo"))
                         .count();
        System.out.println("Count: " + count);
    }

}