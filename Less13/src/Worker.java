/**
 * Created by Александр on 17.03.2016.
 */
public class Worker implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<2000;i++){
            Main.increaseNumber();
        }
    }
}
