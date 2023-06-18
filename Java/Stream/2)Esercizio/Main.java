import java.util.Arrays;
import java.util.List;
/*
 * Produrre una stringa che contenga il primo carattere di tutte le stringhe di una lista
 */

public class Main {
    public static void main(String[] args) {

        List<String> l1 = Arrays.asList("author", "automa", "binario", "automatico", "clemente");

        String output = l1.stream()
                          .map(s -> s.substring(0,1))
                          .reduce("", (r, v) -> r.concat(v));

        System.out.println(output);
    }
}