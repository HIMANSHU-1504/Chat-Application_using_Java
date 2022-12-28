import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.*;
import java.net.*;
public class client {
    public static void main (String args[])
    {
        try
        {
            InetAddress ip=InetAddress.getLocalHost();
            Socket s= new Socket(ip,4021);
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader kb= new BufferedReader(new InputStreamReader(System.in));
            PrintStream ps = new PrintStream(s.getOutputStream());
            System.out.println("Write Something:");
            String str = kb.readLine();
            String str1;
            while(!(str.equals("Exit")))
            {
                ps.println(str);
                str1=br.readLine();
                System.out.println(str1);
                System.out.println("Write Something");
                str= kb.readLine();
                
            }
            ps.close();
            br.close();
            kb.close();
            s.close();
            System.out.println("Client Program ended");
                
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
