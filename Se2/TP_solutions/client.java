
package TPsSE;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;


import java.net.Socket;

public class client {
    public static void start(String serverIpAddress, int serverPort){
        try {
            Socket socket = new Socket(serverIpAddress, serverPort);
            System.out.println("Client Connected");
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            DataInputStream reader = new DataInputStream(socket.getInputStream());
            Scanner scan = new Scanner(System.in);
            String line ="";
            while (!line.equals("bye")) {
            line = scan.nextLine();
            writer.writeUTF(line);
            
            }
            writer.writeUTF(line);
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public static void main(String args []) {
        
           int port = 8000;
           String severIP = "127.0.0.1";
           start(severIP, port);
}
}
