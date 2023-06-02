public class Main {
    public static void main(String[] args) {
        ChatMediator chatMediator = new Chat();

        IUser customer1 = new Customer(chatMediator, "Customer 1");
        IUser customer2 = new Customer(chatMediator, "Customer 2");
        IUser seller = new Seller(chatMediator, "Seller");

        chatMediator.addUser(customer1);
        chatMediator.addUser(customer2);
        chatMediator.addUser(seller);

        customer1.send("Hi, everyone!");
        seller.send("Hello, customers!");
    }
}