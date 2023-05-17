public class Main {
    public static void main(String args[])
    {
        Market shop = new Market();

        Client a = new Client("Mario");
        Client b = new Client("Luigi");

        shop.attach(a, "Accessories");
        shop.attach(b, "Clothes");

        shop.loadClothes("T-Shirt", 10);
        shop.loadAccessories("Clock", 5);

        shop.unloadClothes("T-Shirt", 5);
        shop.unloadAccessories("Clock", 2);

        shop.detach(b, "Accessories");

        shop.loadClothes("Pants", 22);
    }
}
