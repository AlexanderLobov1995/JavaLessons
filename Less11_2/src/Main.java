import java.util.ArrayList;

public class Main {
    private static ArrayList<Mobile> mobiles=new ArrayList<Mobile>();

    public static void main(String[] args){
        for (int i=0;i!=300;i++){
            mobiles.add(new Mobile(12345,"Motorola"));
        }

        for(Mobile m:mobiles){
            System.out.println(m.getNumber()+" "+m.getName());
        }
    }

}
