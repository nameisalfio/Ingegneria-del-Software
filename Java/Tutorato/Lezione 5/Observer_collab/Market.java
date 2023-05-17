import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Market extends AdaptSubject {
    private Set<Observer> clothesObservers = new HashSet<>();
    private Set<Observer> accessoriesObservers = new HashSet<>();

    private Map<String, Integer> clothes = new HashMap<>();
    private Map<String, Integer> accessories = new HashMap<>();

    public static final String CLOTHES = "clothes";
    public static final String ACCESSORIES = "accessories";

    public void attach(Observer obs, String type) {
        if (type.equalsIgnoreCase(CLOTHES)) {
            clothesObservers.add(obs);
        } else if (type.equalsIgnoreCase(ACCESSORIES)) {
            accessoriesObservers.add(obs);
        } else {
            System.out.println("Error attach type");
        }
    }

    public void detach(Observer obs, String type) {
        if (type.equalsIgnoreCase(CLOTHES)) {
            clothesObservers.remove(obs);
        } else if (type.equalsIgnoreCase(ACCESSORIES)) {
            accessoriesObservers.remove(obs);
        } else {
            System.out.println("Error detach type");
        }
    }

    @Override
    public void onChange() {}

    public void onChange(String type, String msg) {
        if (type.equalsIgnoreCase(CLOTHES)) {
            for (Observer obs : clothesObservers) {
                if(obs instanceof Client)
                    obs.update(this, msg);
            }
        } else if (type.equalsIgnoreCase(ACCESSORIES)) {
            for (Observer obs : accessoriesObservers) {
                if(obs instanceof Client)
                    obs.update(this, msg);
            }
        } else {
            System.out.println("Error notify type");
        }
    }

    public void loadClothes(String name, int amount) {
        if (clothes.containsKey(name)) {
            int currentAmount = clothes.get(name);
            clothes.put(name, currentAmount + amount);
        } else {
            clothes.put(name, amount);
        }
        String str = "Carico : " + amount + " " + name;
        onChange(CLOTHES, str);
    }

    public void unloadClothes(String name, int amount) {
        if (clothes.containsKey(name)) {
            int currentAmount = clothes.get(name);
            int newAmount = currentAmount - amount;
            if (newAmount <= 0) {
                clothes.remove(name);
            } else {
                clothes.put(name, newAmount);
            }
            String str = "Scarico : " + amount + " " + name;
            onChange(CLOTHES, str);
        } else {
            System.out.println("Error: " + name + " not found in clothes");
        }
    }

    public void loadAccessories(String name, int amount) {
        if (accessories.containsKey(name)) {
            int currentAmount = accessories.get(name);
            accessories.put(name, currentAmount + amount);
        } else {
            accessories.put(name, amount);
        }
        String str = "Carico : " + amount + " " + name;
        onChange(ACCESSORIES, str);
    }

    public void unloadAccessories(String name, int amount) {
        if (accessories.containsKey(name)) {
            int currentAmount = accessories.get(name);
            int newAmount = currentAmount - amount;
            if (newAmount <= 0) {
                accessories.remove(name);
            } else {
                accessories.put(name, newAmount);
            }
            String str = "Scarico : " + amount + " " + name;
            onChange(ACCESSORIES, str);
        } else {
            System.out.println("Error: " + name + " not found in accessories");
        }
    }

}