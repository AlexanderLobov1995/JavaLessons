import java.io.File;
import javax.swing.*;
import java.util.Scanner;

public class dick {
    static Scanner scn;
    static String [][] m=new String[5][3];
    public static void main(String args[]){
        open();
        read();
        out();
    }

   private static void open(){
       try{
       scn =new Scanner(new File("Res//text.txt"));}
       catch (Exception e)  {JOptionPane.showMessageDialog(null,"Ошибка");}
  }
    private static void read(){
        while(scn.hasNext()) {
            for (int row = 0; row != m.length; row++) {
                for (int col = 0; col != m[row].length; col++) {
                    m[row][col] = scn.next();
                }
            }
        }
    }
    private static void out(){
        for(int row = 0; row != m.length; row++){
            for(int col = 0; col != m[row].length; col++){
                System.out.print(m[row][col] + " ");
            }
            System.out.println();
        }
    }
}
