
public class Main {
    public static Mobile mobiles[]=new Mobile[3];
    public static void main(String[] args){
        mobiles[0]=new Mobile(1234,"IPhone");
        mobiles[1]=new Mobile(2134,"Samsung");
        mobiles[2]=new Mobile(1243,"Nokia");

        for(Mobile m:mobiles){
            System.out.println(m.getNumber()+" "+m.getName());
        }
    }

}
