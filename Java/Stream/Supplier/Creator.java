import java.util.Map;
import java.util.function.Supplier;

public class Creator {

    private static Map<String, Supplier<Prodotto>> map = Map.of("primo", ProdottoA::new,
                                                                "secondo", ProdottoB::new,
                                                                "terzo", ProdottoC::new);
    public static Prodotto getProdotto(String name){
        return map.getOrDefault(name, null).get();
    }

    /*
    *   Senza supplier:
    *
    *   public static Prodotto getProdotto(String name)
    *   {
    *       switch(name){
    *           case "primo" : return new ProdottoA();
    *           case "secondo" : return new ProdottoB();
    *           case "terzo" : return new ProdottoC();
    *           default: return null;
    *       }
    *   }
    */
}
