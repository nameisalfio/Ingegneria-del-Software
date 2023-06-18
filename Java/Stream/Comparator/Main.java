import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Persona> list = List.of(new Persona("Pippo", 46),
                                     new Persona("Alessio", 23),
                                     new Persona("Giovanni", 42),
                                     new Persona("Ferdinando", 18),
                                     new Persona("Lele", 62));

        Optional<Persona> max = list.stream()
                                    .filter(p -> p.getEta() < 50)
                                    .max(Comparator.comparing(Persona::getEta));
                                    // oppure .reduce(Persona::getOlder);
                                        
        if(max.isPresent())
            System.out.println("Il più anziano al di sotto dei 50 anni è " + max.get().getNome());
    }
}

