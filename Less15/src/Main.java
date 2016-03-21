import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

//Array Blocking Queue
public class Main {
    private static Object obj=new Object();
    private static ArrayBlockingQueue<Object> list=new ArrayBlockingQueue<Object>(1000);
    public static void main(String[] args){
        addList();
        proceed();
    }

    private static void proceed() {
        System.out.println(list.size());
        Object object=null;

        for(Object m: list){
            list.remove(m);
        }

        /*while (list.size()!=0){
            for(Object m: list){
                object=m;
                break;
            }
            list.remove(object);
        }*/



        System.out.println(list.size());
    }

    private static void addList() {
        for(int i=0;i<5;i++){
            list.add(obj);
        }
    }
}
