import java.util.function.Predicate;
import java.util.stream.Stream;

class Main
{
    public static void main(String[] args) 
    {
        System.out.println();
        Predicate<Integer> positive = x -> x >= 0;   
        Stream<Integer> result = Stream.of(2, 5, -3, 9, -2)
                                       .filter(positive)
                                       .forEach(System.out::println);
    }
}