import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++)
            list.add(random.nextInt(20));

        System.out.print("Before: ");
        for(Integer x : list)
            System.out.print(x + " ");
        
        System.out.print("\n\nAfter: ");
        list.stream()
            .sorted(Comparator.naturalOrder())
            .forEach(x -> System.out.print(x + " "));
            
        System.out.println();
    }
}
