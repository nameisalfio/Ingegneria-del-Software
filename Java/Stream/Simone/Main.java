import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Main 
{    
    record Book(String title, String category, Integer price, Integer amount){}
    public static void main(String[] args)
    {
        es3();
    }

    static void es1()
    {
        //Trovare la parola più lunga di una lista di frasi

        List<String> l = List.of("Ciao , come stai ?", "Supercalifragilistichespiralidoso , sono io", " ", "Questa è la stringa più lunga ma non contiene la parola più lunga");

        Optional<String> str = l.stream()   
                                .map(s -> s.split(" "))
                                .map(a -> Arrays.stream(a)
                                .max(Comparator.comparing(String::length)).orElse(""))
                                .max(Comparator.comparing(String::length));
                                
        System.out.println("Longest word:");
        if(str.isPresent())
            System.out.println(str.get());
    }                                

    static void es2()
    {
        // il numero totale di caratteri minuscoli in una lista di stringhe

        List<String> l = List.of("Ciao , come stai ?", "Supercalifragilistichespiralidoso , sono io", " ", "Questa è la stringa più lunga ma non contiene la parola più lunga");
        List<String> l2 = List.of("");

        Long num = l.stream()
                    .flatMap(s -> Arrays.stream(s.split("")))
                    .map(s -> (s.length() > 0 ? s.charAt(0) : ' '))
                    .filter(p -> p >= 'a' && p <= 'z')
                    .count();
        System.out.println("Result : " + num);

        Long num2 = l2.stream()
                     .flatMap(s -> Arrays.stream(s.split("")))
                     .map(s -> (s.length() > 0 ? s.charAt(0) : ' '))
                     .filter(p -> p >= 'a' && p <= 'z')
                     .count();

        System.out.println("Result2 : " + num2);
    }

    static void es3()
    {
        // Possibile guadagno per ogni categoria di libro 
        List<Book> l = List.of(new Book("Libro1", "CategoriaA", 20, 1),
                               new Book("Libro2", "CategoriaB", 12, 1),
                               new Book("Libro3", "CategoriaA", 4, 1),
                               new Book("Libro4", "CategoriaB", 18, 2),
                               new Book("Libro5", "CategoriaB", 30, 1));
        l.stream()
         .map(Book::category)
         .distinct()
         .map(g -> new String(g + " " + l.stream()
                                         .filter(lib -> lib.category() == g)
                                         .map(lib -> lib.amount() * lib.price())
                                         .reduce(0, Integer::sum)))
         .forEach(System.out::println);

    }

    static void es4()
    {
        // libri il cui titolo è composto da sole due parole
        List<Book> l = List.of(new Book("Libro 1", "CategoriaA", 20, 1),
                               new Book("Libro2", "CategoriaB", 12, 1),
                               new Book("Libro 3", "CategoriaA", 4, 1),
                               new Book("Libro4", "CategoriaB", 18, 2),
                               new Book("Libro 5", "CategoriaB", 30, 1));

        Function<String, Boolean> twoWords = s->Arrays.stream(s.split(" "))
                                                      .filter(w -> w.length() > 0)
                                                      .count() == 2;
        l.stream()
         .map(b -> b.title())
         .filter(s -> twoWords.apply(s))
         .forEach(System.out::println); 

        //oppure

        l.stream()
         .map(b -> b.title())
         .filter(t -> Arrays.stream(t.split(" "))
                            .filter(c -> c.length() > 0)
                            .count() == 2)
        .forEach(System.out::println);
    }
}