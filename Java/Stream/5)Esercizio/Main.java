import java.util.List;
/*
 * Data una lista di interi verificare se è ordinata
*/
import java.util.stream.IntStream;

public class Main {

    static int prev;
    static List<Integer> list = List.of(2,3,4,5,6,2,8,9); 
    public static void main(String[] args) {
        Boolean output = isSorted();
        Boolean output2 = isSorted2();

        System.out.println(output);
        System.out.println(output2);
    }

    private static Boolean isSorted(){
        return IntStream.rangeClosed(0, list.size()-1)
                        .filter(i -> list.get(i) < list.get(i+1))
                        .peek(v -> System.out.println(list.get(v) + " > " + list.get(v+1)))
                        .findAny()
                        .isEmpty();
    }

    private static Boolean isSorted2(){    //non usabile in parallelo poichè conserva uno stato globale
        prev = list.get(0);
        return list.stream()
                   .filter(v -> lessThanPrev(v))
                   .findAny()
                   .isEmpty();
    }

    private static Boolean lessThanPrev(int x){
        int p = prev;
        prev = x;
        return x < p;

    }
} 
