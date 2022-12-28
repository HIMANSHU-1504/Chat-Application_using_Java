import java.io.PrintStream;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            ServerSocket ss=new ServerSocket(4021);
            System.out.println("waiting for client to connect");
            Socket s =ss.accept() ;
            System.out.println("connection established");
            
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
            PrintStream ps= new PrintStream(s.getOutputStream());
            
            String str,str1;
            str=br.readLine();
            while(str!=null)
            {
                System.out.println(str);
                System.out.println("Write something:");
                str1=kb.readLine();
                ps.println(str1);
                
                str=br.readLine();
            }
            ps.close();
            br.close();
            kb.close();
            ss.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }    
        
                        
                        
            }
    
}
