import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Persona> list = List.of(new Persona("Pippo", 46),
                                     new Persona("Alessio", 23),
                                     new Persona("Giovanni", 42),
                                     new Persona("Ferdinando", 18),
                                     new Persona("Lele", 62));

        System.out.println("Nomi : ");
        List<String> nomi = list .stream()
                                  .map(p -> p.getNome())
                                  .collect(Collectors.toList());
        nomi.forEach(System.out::println);

        System.out.println("\nEtà : ");
        List<Integer> eta = list .stream()
                                 .map(p -> p.getEta())
                                 .collect(Collectors.toList());
        eta.forEach(System.out::println);
    }
}

