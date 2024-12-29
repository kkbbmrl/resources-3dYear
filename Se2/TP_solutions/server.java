package TPsSE;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {

    public static void start(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.err.println("server started end is waiting for a client");

            Socket clientSocket;
            while ((clientSocket = ss.accept()) != null) {
                System.out.println("Client accepted");
                threadserver ts = new threadserver(clientSocket);
                ts.start();

            }
        } catch (IOException ex) {
            Logger.getLogger(threadserver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        int port = 8000;
        start(port);
    }
}
