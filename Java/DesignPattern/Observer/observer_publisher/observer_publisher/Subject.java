import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.random.*;

public class Subject {

    RandomGenerator r = new Random(0);

    private SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>(ForkJoinPool.commonPool() , 100) ;
    //implementa l'interfaccia Publisher<T> ed è gestisce un gruppo di client iscritti . 
    private List<Integer> list =new ArrayList<>() ;

    public void attach( Subscriber<Integer> sub ){
        publisher.subscribe(sub);
        // subscribe chiama implicitamente il metodo onsubscribe del subscriber.
    }

   public void setState(){
         int x = r.nextInt(10, 20);
         list.add(x);
         System.out.println("elemento inserito");
         publisher.submit(x); 
         //invia notifica agli oggetti iscritti 
   }

   public void close() throws InterruptedException{
      System.out.println("Chiudi Subject ");
      Thread.sleep(400);
      publisher.close();
   }

   public void getPublisherInformation(){
       System.out.println(publisher.getMaxBufferCapacity());
       System.out.println(publisher.getSubscribers());
   }
}
