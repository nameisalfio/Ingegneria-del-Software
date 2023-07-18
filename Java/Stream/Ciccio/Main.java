import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public record Auto(String categoria, String colore, Double costo, String modello){}
    public record Figura(int l1, int l2, int l3, int l4, int a1, int a2, int a3, int a4){}
    public record Triangolo(int l1, int l2, int l3, int a1, int a2, int a3){}

    private static List<Auto> al = List.of( new Auto("A", "BLU", 120.0, "Berlina"),
                                            new Auto("B", "ROSSO", 170.0, "Sportiva"),
                                            new Auto("C", "VERDE", 220.0, "SUV"));

    private static List<Figura> figure = List.of( new Figura(1, 2, 3, 4, 5, 6, 7, 8),
                                                  new Figura(2, 3, 4, 5, 6, 7, 8, 9),
                                                  new Figura(3, 4, 5, 6, 7, 8, 9, 10));

    private static List<Triangolo> t = List.of( new Triangolo(1, 2, 3, 90, 6, 7),
                                                new Triangolo(2, 3, 4, 6, 7, 8),
                                                new Triangolo(3, 4, 5, 7, 8, 9));

    public static void main(String[] args) {
        System.out.println(metodo7());
    }

    public static List<Auto> metodo1(){
        // Incrementa il costo di ogni auto del 5%

        return al.stream()
                 .map(a -> new Auto(a.categoria, a.colore, a.costo*(1.05), a.modello))
                 .toList();
    }

    // Incrementa il costo di ogni auto del 5%
    public static List<Auto> metodo1_2(){
        return al.stream()
                 .mapToDouble(a -> a.costo * 1.05)
                 .mapToObj(a -> new Auto(" ", null, a, null))
                 .collect(Collectors.toList());
    }   
    
    // Somma dei costi di tutte le auto
    public static Double metodo2(){
        return al.stream()
                 .map(a -> a.costo)
                 .reduce(0.0, (a, v) -> a+v);
    }

    public static Double metodo2_2(){
        return al.stream()
                 .mapToDouble(Auto::costo)
                 .sum();
    }

    // Trovare il minimo dei costi delle istanze di auto
    public static Double metodo3(){
        return al.stream()
                 .mapToDouble(Auto::costo)
                 .min()
                 .orElse(0.0);
    }    

    public static Double metodo3_2(){
        return al.stream()
                 .map(Auto::costo)
                 .sorted()
                 .findFirst() // non puoi fare limit(1)
                 .orElse(0.0);
    }    

    // Ordinare una lista
    public static void metodo4(){
        List<Auto> sort = al.stream()
                            .sorted(Comparator.comparing(Auto::costo))
                            .toList();

        System.out.println("Sorted list: ");
        for(Auto a : sort)
            System.out.println(a);
    }

    // Auto di costo maggiore
    public static Auto metodo5(){        
        return al.stream()
                 .max(Comparator.comparing(Auto::costo))
                 .orElse(null);
    }

    // Il costo dell'auto col costo minore
    public static Double metodo6(){        
        return al.stream()
                 .mapToDouble(Auto::costo)
                 .min()
                 .orElse(0.0);
    }

    // Verificare che le auto siano ordinate per costo
    public static Boolean metodo7(){
        Double first = al.get(0).costo(); // salvo il costo del primo elemento

        return al.stream()
                 .filter(a -> a.costo() < first) // rimangono solo quelli che violano l'ordinamento
                 .toList()
                 .isEmpty();
    }

    public static Boolean metodo7_2(){
        Double first = al.get(0).costo();
        return al.stream()
                 .anyMatch(a -> a.costo() < first);  // torna true se almeno un elemento viola l'ordinamento
    }
     
    // La lista dei lati maggiori per ogni figura
    public static List<Integer> metodo8() {
        return figure.stream()
                     .map(f -> List.of(f.l1, f.l2, f.l3, f.l4))
                     .map(l -> l.stream().reduce((a, b) -> a > b ? a : b).get())
                     .toList();
    }

    public static List<Integer> metodo8_2() {
        return figure.stream()
                     .map(f -> List.of(f.l1, f.l2, f.l3, f.l4))
                     .map(l -> l.stream().max(Integer::compareTo).get())
                     .toList();
    }

    // La lista dell'angolo minore per ogni figura
    public static List<Integer> metodo9() {
        return figure.stream()
                     .map(f -> List.of(f.a1, f.a2, f.a3, f.a4))
                     .map(l -> l.stream().min(Comparator.naturalOrder()).get())
                     .toList();
    }

    // Il perimetro maggiore dei triangoli
    public static Integer metodo10(){
        return t.stream()
                .map(l -> l.l1 + l.l2 + l.l3)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .reduce(0, (a, v)->a+v);
    }

    public static Integer metodo10_2(){
        return t.stream()
                .map(l -> l.l1 + l.l2 + l.l3)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static Integer metodo10_3(){
        return t.stream()
                .mapToInt(l -> l.l1 + l.l2 + l.l3)
                .max()
                .orElse(0);
    }
    
    // La somma dei perimetri delle istanze di t
    public static Integer metodo11(){
        return t.stream()
                .map(t -> List.of(t.l1, t.l2, t.l3))
                .map(l -> l.stream().reduce(0, (a, v)-> a+v))
                .reduce(0, (a, v)-> a+v);
    }

    public static Integer metodo11_2(){
        return t.stream()
                .mapToInt(l -> l.l1 + l.l2 + l.l3)
                .sum();
    }

    // Le aree dei triangoli rettangoli
    public static List<Integer> metodo12(){
        return t.stream()
                .filter(x -> x.a1 == 90 || x.a2 == 90 || x.a3 == 90)
                .map(l -> l.l1 * l.l2)
                .toList();
    }

    // La lista dei lati minori delle istanze di t1
    public static List<Integer> metodo13(){
        return t.stream()
                .map(l -> List.of(l.l1, l.l2, l.l3))
                .map(l -> l.stream().min(Comparator.naturalOrder()).orElse(0))
                .toList();
    }

    // Tornare una lista di tutti triangoli rettangoli a partire da t(triangoli rettangoli)
    public static List<Triangolo> metodo14(){
        return t.stream()
                .map(l -> new Triangolo(90, l.l2, l.l3, l.a1, l.a2, l.a3))
                .toList();
    }
    
    // Fornire una lista dove tutte le auto sono verdi a partire da al
    public static List<Auto> metodo15(){
        return al.stream()
                 .map(l -> new Auto(l.categoria, "Verde", l.costo, l.modello))
                 .toList();
    }   
    
    // Tornare una lista di figure copn perimetro doppio a partire da figure
    public static List<Figura> metodo16(){
        return figure.stream()
                     .map(f -> new Figura(f.l1*2, f.l2*2, f.l3*2, f.l4*2, f.a1, f.a2, f.a3, f.a4))
                     .toList();
    }
}