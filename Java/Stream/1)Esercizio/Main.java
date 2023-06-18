import java.util.Arrays;
import java.util.List;
/*
 * Produrre una lista che abbia tutte le stringhe che iniziano per "au"
 */
public class Main {
    public static void main(String[] args) {

        List<String> l1 = Arrays.asList("author", "automa", "binario", "automatico", "clemente");
        final String pref = "au";

        List<String> output = l1.stream()
                                .filter(x -> x.startsWith(pref))
                                .toList();

        for(String s : output) System.out.println(s);
    }
}