import javax.swing.JFrame;

public class dick {
    public static void main(String...args){
        Reader r = new Reader("Program");
        r.setVisible(true);
        r.setResizable(false);
        r.setSize(250,350);
        r.setLocationRelativeTo(null);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
