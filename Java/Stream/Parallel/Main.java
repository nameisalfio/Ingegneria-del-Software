import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Long> list = Stream.generate(() -> Math.round(Math.random()*10))
                                   .limit(10)
                                   .toList();

        System.out.println("Seriale: \n");
        list.stream()
            .forEach(a -> System.out.println(a + ": " + Thread.currentThread().getName()));

        System.out.println("\nStream.parallel(): \n");
        list.stream()
            .parallel()
            .forEach(a -> System.out.println(a + ": " + Thread.currentThread().getName()));

        System.out.println("\nCollection.parallelStream: \n");
        list.parallelStream()
            .forEach(a -> System.out.println(a + ": " + Thread.currentThread().getName()));
    }
}

