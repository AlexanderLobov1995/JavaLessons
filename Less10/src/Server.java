import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Александр on 01.03.2016.
 */
public class Server implements Runnable {
    static public Socket connection;
    static public ServerSocket server;
    static public ObjectInputStream input;
    static public ObjectOutputStream output;

    public void run() {
        try {
            server =new ServerSocket(5678,10);
            while(true){
                connection= server.accept();
                output= new ObjectOutputStream(connection.getOutputStream());
                input=new ObjectInputStream(connection.getInputStream());
                output.writeObject("Это сервер тебе передал: "+(String)input.readObject());
            }
        } catch (IOException e)
        {
        }catch (ClassNotFoundException e) {}
    }
}
