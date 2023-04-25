public class Client {
    public static void main(String[] args) {

        //Shape Factory Regular
        AbstractFactory SFRegular = FactoryProducer.getFactory(false);
        Shape shape1 = SFRegular.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = SFRegular.getShape("SQUARE");
        shape2.draw();

        //Shape Factory Rounded
        AbstractFactory SFRounded = FactoryProducer.getFactory(true);
        Shape shape3 = SFRounded.getShape("RECTANGLE");
        shape3.draw();
        Shape shape4 = SFRounded.getShape("SQUARE");
        shape4.draw();
    }
}