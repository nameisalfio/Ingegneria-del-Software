import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
    {
        Function<String, Integer> strLen = x -> x.length(); 
        Function<Integer, String> toBin = x -> Integer.toBinaryString(x);

        Optional<Integer> result = Stream.of("Albero", "Martello", "Bancomat", "Trapano", "Pinoli")
                                         .map(strLen)
                                         .reduce(Integer::sum);
                                         
        if (result.isPresent()) {
            System.out.println("Risultato: " + result.get());
            System.out.println("Lunghezza in formato binario: " + toBin.apply(result.get()));
        }
    }
}