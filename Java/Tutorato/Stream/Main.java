import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;

public class Main 
{
    public record Persona(String name, Integer age, String rule){}
    public record Prodotto(String name, Double price) {}
    public record Commento(String text, LocalDate date) {}
    public record Utente(String name, List<Commento> comment) {}

    public static void main(String[] args) 
    {
        es14();
    }

    static void es1()
    {
        List<Persona> list = List.of(new Persona("Kent", 29, "CTO"),
                                     new Persona("Luigi", 25, "Programmer"),
                                     new Persona("Andrea", 26, "GrLeader"),
                                     new Persona("Sofia", 26, "Programmer"),
                                     new Persona("Alfio",63, "Programmer"));
        list.stream()
            .filter(p -> p.age() < 30)
            .filter(p -> p.rule().equals("Programmers"))
            .map(p -> p.name())
            .forEach(System.out::println);
    }

    static void es2()
    {
        List<Persona> list = List.of(new Persona("Kent", 29, "CTO"),
                                     new Persona("Luigi", 25, "Programmer"),
                                     new Persona("Andrea", 26, "GrLeader"),
                                     new Persona("Sofia", 26, "Programmer"),
                                     new Persona("Alfio",63, "Programmer"));
        list.stream()
            .map(p -> p.rule())
            .distinct()
            .forEach(System.out::println);
    }

    static void es3()
    {
        List<String> list = List.of("author", "auto", "antico", "binding", "begin", "big");
        String prefix = "au";
        list.stream()
            .filter(s -> s.startsWith(prefix))
            .forEach(System.out::println);
    }

    static void es4()
    {
        List<String> list = List.of("author", "banana", "cane");
        Optional<String> str = list.stream()
                                   .filter(s -> s.length() > 0)
                                   .map(s -> s.substring(0, 1))
                                   .reduce(String::concat);

        if(str.isPresent())
            System.out.println("Risultato: " + str.get());
    }

    static void es5()
    {
        List<int[]> list = List.of(new int[]{1,2,3}, new int[]{3,4,5},
                                   new int[]{3,4,9}, new int[]{5,6,7});
        
        List<Integer> result = list.stream()
                               .filter(t -> t[0] + t[1] >= t[2])
                               .filter(t -> t[0] + t[2] >= t[1])
                               .filter(t -> t[1] + t[2] >= t[0])
                               .map(t -> t[0] + t[1] + t[2])
                               .toList();

        System.out.println("Lista dei perimetri: ");
        result.forEach(s -> System.out.print(s +" "));
    }

    static void es6()
    {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> no_list = List.of(1, 2, 0, 4, 5, 6, 7, 8, 9);

        Boolean isOrdered = IntStream.rangeClosed(0, no_list.size()-1)
                                     .filter(i -> no_list.get(i) < no_list.get(i+1))
                                     .findAny()
                                     .isEmpty();
            
        Boolean isOrdered2 = list.stream()
                                 .reduce(Integer.MIN_VALUE, (x, y) -> (x == null || x > y) ? null : y) != null;

        System.out.println("no_list: " + isOrdered);
        System.out.println("list: " + isOrdered2);

    }

    static void es7()
    {
        List<Prodotto> list = List.of(new Prodotto("Prod1", 3.50),
                                      new Prodotto("Prod2", 13.50),
                                      new Prodotto("Prod3", 29.60),
                                      new Prodotto("Prod4", 5.30));
                                    
        Double tot = list.stream()
                         .filter(p -> p.price() >= 10)
                         .map(p -> p.price)
                         .reduce(0.0, (x, y) -> x + y);

        System.out.println("Totale: " + tot);
    }

    static void es8(Integer num, Integer stop)
    {
        List<Integer> mult = Stream.iterate(num, n -> n + num)
                                    .limit(stop)
                                    .toList();

        System.out.print("I primi " + stop + " multipli di " + num + "\n--> ");
        mult.forEach(s -> System.out.print(s + " "));
        System.out.println("");
    }

    static void es9()
    {
        List<Utente> utenti = List.of(
                new Utente("u1", List.of(
                        new Commento("c1", LocalDate.of(2021, 1, 1)),
                        new Commento("c2", LocalDate.of(2021, 1, 2))
                )),
                new Utente("u2", List.of(
                        new Commento("c4", LocalDate.of(2021, 1, 3)),
                        new Commento("c3", LocalDate.of(2021, 1, 4)),
                        new Commento("p", LocalDate.of(2021, 1, 5))
                )));

        utenti.stream()
               .flatMap(s -> s.comment().stream())
               .sorted(Comparator.comparing(s -> s.date()))
               .forEach(System.out::println);
    }

    static void es10()
    {
        // Restituire tutti gli utenti che hanno pubblicato un commento prima di una certa data 
        LocalDate date = LocalDate.of(2021, 1, 3);
        List<Utente> l = List.of(
                new Utente("u1",
                        List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                                new Commento("c1", LocalDate.of(2021, 1, 1)),
                                new Commento("c5", LocalDate.of(2021, 1, 5)))),
                new Utente("u2",
                        List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                                new Commento("c3", LocalDate.of(2021, 1, 3)))));

       /* l.stream()
         .filter(s -> s.comment().stream()
                                 .filter(w -> w.date().isBefore(date))
                                 .findAny()
                                 .isPresent()
                )
         .forEach(s -> System.out.println(s.name()));*/

        l.stream()
         .filter(s -> s.comment().stream()
                                 .anyMatch(p -> p.date().isBefore(date))
                )
        .forEach(s -> System.out.println(s.name()));
    }

    static void es11()
    {
        //Restituire l'utente che ha publicato il commento più recente

        List<Utente> l = List.of(
                new Utente("u1",
                        List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                                new Commento("c1", LocalDate.of(2021, 1, 1)),
                                new Commento("c5", LocalDate.of(2021, 1, 5)))),
                new Utente("u2",
                        List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                                new Commento("c3", LocalDate.of(2021, 1, 1)))),
                new Utente("u3",
                        List.of()));

        Optional<Utente> result = l.stream()
                                   .max(Comparator.comparing(u -> u.comment.stream()
                                                                           .map(Commento::date)
                                                                           .max(LocalDate::compareTo)
                                                                           .orElse(LocalDate.MIN)));
        result.ifPresent(System.out::println);
    }

    static void es12(Integer min, Integer max)
    {
        // Persone che hanno un età compresa tra min e max

        List<Persona> list = List.of(new Persona("Kent", 29, "CTO"),
                                new Persona("Luigi", 37, "Programmer"),
                                new Persona("Andrea", 26, "GrLeader"),
                                new Persona("Sofia", 42, "Programmer"),
                                new Persona("Alfio",63, "Programmer"));
        
        List<Persona> res = list.stream()
                                .filter(p -> p.age() > min && p.age() < max)
                                .toList();
        for (Persona p : res)
            System.out.println(p);
    }

    static void es13()
    {
        // Somma delle età delle persone

        List<Persona> list = List.of(new Persona("Kent", 29, "CTO"),
                        new Persona("Luigi", 37, "Programmer"),
                        new Persona("Andrea", 26, "GrLeader"),
                        new Persona("Sofia", 42, "Programmer"),
                        new Persona("Alfio",63, "Programmer"));
        
        Integer res = list.stream()
                          .map(p -> p.age)
                          .reduce(0, (accum, v) -> (accum + v));

        System.out.println("Result: " + res);
    }

    static void es14()
    {
        // Tornare una mappa di Nome, Ruolo

        List<Persona> list = List.of(new Persona("Kent", 29, "CTO"),
                new Persona("Luigi", 37, "Programmer"),
                new Persona("Andrea", 26, "GrLeader"),
                new Persona("Sofia", 42, "Programmer"),
                new Persona("Alfio",63, "Programmer"));
        
        Map<String, String> m = list.stream()
                                        .collect(Collectors.toMap(Persona::name, Persona::rule));
        System.out.println(m);
    }
}
