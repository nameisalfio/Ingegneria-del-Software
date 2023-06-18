import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Persona> list = List.of(new Persona("Pippo", 46),
                                     new Persona("Alessio", 23),
                                     new Persona("Giovanni", 42),
                                     new Persona("Ferdinando", 18),
                                     new Persona("Lele", 62));

        int nameLen = list.stream()
                          .mapToInt(p -> p.getNome().length())       // da Stream a IntStream
                          .sum();
        System.out.println("Sum of name lengths: " + nameLen);

        System.out.print("Integers from IntStream: ");        
        IntStream.rangeClosed(0, 10)
                 .boxed()                                           //da IntStream a Stream<Integer>
                 .forEach(e -> System.out.print(e + " "));

        System.out.print("\nBinary from IntStream: ");        
        IntStream.rangeClosed(0, 8)    //da IntStream a Object
                 .mapToObj(a -> Integer.toBinaryString(a))
                 .forEach(s -> System.out.print(s + " "));
        System.out.println(" ");
    }
}
