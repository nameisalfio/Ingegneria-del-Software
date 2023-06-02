public class Client {
    
    static Subject sub = new Subject();

    static Subject sub1 = new Subject();

    static Observer ob1 = new Observer();

    static Observer ob2 = new Observer();

    public static  void test(){
        // con questo test salta all' occhio che ogni coppia (Subject , observer) ha il suo thread   
        System.out.println(Thread.currentThread().getName());
        sub.attach( ob1 );
        sub.attach( ob2 );
        sub1.attach( ob1 );
        sub1.attach( ob2 );
        sub.setState();
        sub.setState();
        sub1.setState();
        sub1.setState();
        try {
            sub.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] argv ){
        test();
    }
}
