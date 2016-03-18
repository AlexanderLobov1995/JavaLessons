import java.util.*;
import javax.swing.JOptionPane;
public class dick {
    static Formatter f;
    static Scanner scn;

    public static void main(String...args){
        try {
            scn = new Scanner(System.in);
            f = new Formatter("Res//1.txt");
            System.out.println("Сколько вам лет?");
            int a= Integer.parseInt(scn.next());
            System.out.println("Как вас зовут?");
            String b= scn.next();
            System.out.println("Где вы живете?");
            String c=scn.next();
           // a = Integer.parseInt(JOptionPane.showInputDialog("Сколько вам лет?"));
           // b = JOptionPane.showInputDialog("Как вас зовут?");
            //c = JOptionPane.showInputDialog("Где вы живете?");

            f.format("Меня зовут %s, мне %d лет. Я живу в городе %s",b,a,c);
            f.close();

        }catch (Exception e){JOptionPane.showMessageDialog(null,"Ошибка");}

    }
}
