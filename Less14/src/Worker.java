import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Александр on 19.03.2016.
 */
public class Worker{
    private ArrayList<Integer> list1= new ArrayList<Integer>();
    private ArrayList<Integer> list2= new ArrayList<Integer>();
    private Random random=new Random();
    private Object obj1=new Object();
    private Object obj2=new Object();

    public void start(){
        System.out.println("Начинаем...");
        long startTime=System.currentTimeMillis();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                proceed();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                proceed();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime=System.currentTimeMillis();
        System.out.println("Time: "+(endTime-startTime));
        System.out.println("List1: "+list1.size()+"\n"
                +"List2: "+list2.size());
    }


    private void proceed(){
        for(int i=0;i<1000;i++){
            partOne();
            partTwo();
        }
    }

    private void partOne(){
        synchronized (obj1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt());
        }

    }

    private void partTwo(){
        synchronized (obj2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt());
        }
    }

}
