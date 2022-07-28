import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SocketServer {
    public static void main (String args []){

        try {
            ServerSocket ss = new ServerSocket(2000);
            Socket s = ss.accept();

            Scanner sc = new Scanner(System.in);
            DataInputStream sin = new DataInputStream(s.getInputStream());
            DataOutputStream sout = new DataOutputStream(s.getOutputStream());

            String str1 = "", str2 = "";
            while(!str1.equals("bye")){
                str2 = sc.nextLine();
                sout.writeUTF(str2);
                sout.flush();

                str1 = (String)sin.readUTF();
                System.out.println(str1);
            }

            s.close();
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
