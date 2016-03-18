import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main extends JFrame implements Runnable {
    static public Socket connection;
    static  public ObjectInputStream input;
    static public ObjectOutput output;

    public Main(String program) {
        super(program);
        setLayout(new FlowLayout());
        setSize(300,300);
        setVisible(true);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField t1=new JTextField(10);
        JButton b1=new JButton("Send");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b1){
                    sendData(t1.getText());
                }
            }
        });
        add(t1);
        add(b1);

    }

    public static void main(String[] argc) {
        new Thread(new Main("Program")).start();
        new Thread(new Server()).start();
    }

    @Override
    public void run() {
        try {

            while(true){
                connection= new Socket(InetAddress.getByName("127.0.0.1"),5678);
                output= new ObjectOutputStream(connection.getOutputStream());
                input=new ObjectInputStream(connection.getInputStream());
                JOptionPane.showMessageDialog(null,(String)input.readObject());

            }
        } catch (IOException e) {
        } catch (HeadlessException e){
        } catch (ClassNotFoundException e){}
    }

    public void sendData(Object obj){
        try {
            System.out.print("1");
            output.flush();
            output.writeObject(obj);
        } catch (IOException e) {}

    }
}
