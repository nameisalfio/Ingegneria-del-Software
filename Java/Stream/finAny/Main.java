import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Persona> list = List.of(new Persona("Pippo", 46, "Programmer"),
                                     new Persona("Alessio", 23, "Teacher"),
                                     new Persona("Giovanni", 42, "Builder"),
                                     new Persona("Ferdinando", 18, "Programmer"),
                                     new Persona("Lele", 62, "Plant Builder"));

        Optional<Persona> persona = list.stream()
                                    .filter(p -> p.getImpiego() == "Programmer")
                                    .findAny();
                                    //findFirts();

        if(persona.isPresent())
            System.out.println("Un programmatore : " + persona.get().getNome());
    }
}
