import java.util.Arrays;
import java.util.List;
/*
 * Data una lista di terne di numeri verificare se ciacuna terna prendendo
 * dalla lista tre numeri contigui costituisce un rettangolo
*/
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(2,3,4,5,6,7,8,9); 

        List<int[]> output = IntStream.rangeClosed(0, list.size()-3)
                                      .mapToObj(i -> new int[]{list.get(i), list.get(i+1), list.get(i+2)})
                                      .filter(v -> v[0] < v[1] + v[2])
                                      .filter(v -> v[1] < v[0] + v[2])
                                      .filter(v -> v[2] < v[0] + v[1])
                                      .collect(Collectors.toList());

        for(int[] x : output) System.out.println(Arrays.toString(x));
    }
} 
