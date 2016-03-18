import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Profile> profiles=new ArrayList<Profile>();
    public static void main(String[] args){
        profiles=(ArrayList<Profile>)deserData("Profiles");
        Profile profile=new Profile();
        System.out.println(profiles.size());
        profile.setName(JOptionPane.showInputDialog(null,"Введите имя"));
        profile.setSurname(JOptionPane.showInputDialog(null,"Введите фмилию"));
        profiles.add(profile);
        for(Profile pr: profiles){System.out.println(pr.getName()+" "+pr.getSurname());}
        System.out.println(profiles.size());
        serData("Profiles",profiles);
    }

    private static void serData(String fileName,Object obj){
        try {
            FileOutputStream output=new FileOutputStream(fileName+".ser");
            ObjectOutputStream out=new ObjectOutputStream(output);
            out.writeObject(obj);
            out.close();
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException e) {
            System.exit(2);
        }
    }

    private static Object deserData(String fileName){
        Object retObject=null;
        try {
            FileInputStream input=new FileInputStream(fileName+".ser");
            ObjectInputStream in=new ObjectInputStream(input);
            retObject=in.readObject();
            input.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException e) {
            System.exit(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(3);
        }
        return retObject;
    }


}
