import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class Observer implements Subscriber<Integer> {
    
    private List<Subscription> s = new ArrayList<>() ;

    @Override
    public void onSubscribe(Subscription subscription) {
        s.add(0,subscription) ;
        s.get(0).request(3); // numero di notifiche che voglio gestire
        System.out.println(" Observer aggiunto ");
        s.get(0).notify();
    }

    @Override
    public void onNext(Integer item) {
        System.out.println( Thread.currentThread().getName());
        System.out.println( "Ho aggiunto il valore :"+ item );
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Errore");
    }

    @Override
    public void onComplete() {
        System.out.println("Hai chiuso il Subject");
    }

}
