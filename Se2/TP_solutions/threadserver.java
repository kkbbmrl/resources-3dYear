package TPsSE;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class threadserver extends Thread{

    Socket socket;
     public threadserver (Socket socket ){
         this.socket= socket;
     }
     
     public void run(){
         
         try{
             DataInputStream in = new DataInputStream(
                     new BufferedInputStream(socket.getInputStream()));
             
             String line= "";
             while (!line.equals("bye")){
                 
                 line = in.readUTF();
                 System.out.println(line);
             }
             System.out.println("closing connection");
             
             in.close();
             socket.close();
             
         }catch(IOException ex){
             Logger.getLogger(threadserver.class.getName()).log(Level.SEVERE, null, ex);
         }
     }    
}
