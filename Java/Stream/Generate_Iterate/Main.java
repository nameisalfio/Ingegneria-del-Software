import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream.iterate(1, n -> n*2)
               .limit(10)
               .forEach(s -> System.out.print(s + " "));

        System.out.println("");
        
        Stream.generate(() -> Math.round(Math.random()*30))
              .limit(10)
              .forEach(s -> System.out.print(s + " "));
        System.out.println("");
    }
}
