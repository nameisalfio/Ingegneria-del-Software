import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Main
{
    public static void main(String[] args) 
    {
        System.out.println();
        Predicate<Integer> positive = x -> x >= 0;   
        Optional<Integer> result = Stream.of(2, 5, -3, 9, -2)
                                .filter(positive)
                                //.reduce(0, (accum, v)->accum+v);
                                .reduce(Integer::sum);
        if(result.isPresent())
            System.out.println("Result: " + result);
        else 
            System.out.println("Optional is empty");
    }

}