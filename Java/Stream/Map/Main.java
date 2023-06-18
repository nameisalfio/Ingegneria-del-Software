import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Persona> list = List.of(new Persona("Pippo", 46),
                                     new Persona("Alessio", 23),
                                     new Persona("Giovanni", 42),
                                     new Persona("Ferdinando", 18),
                                     new Persona("Lele", 62));

        Optional<Integer> max = list.stream()
                                    .map(Persona::getEta)
                                    .reduce(Integer::max);

        if(max.isPresent())
            System.out.println("Età massima : " + max);
    }
}
