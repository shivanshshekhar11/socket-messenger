import java.net.*;
import java.io.*;
import java.util.*;

public class SocketClient {
    public static void main(String args[]){

        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 2000);
            DataInputStream sin = new DataInputStream(s.getInputStream());
            DataOutputStream sout = new DataOutputStream(s.getOutputStream());

            String str1 = "", str2 = "";
            while(!str1.equals("bye")){
                str1 = (String)sin.readUTF();
                System.out.println(str1);

                str2 = sc.nextLine();
                sout.writeUTF(str2);
                sout.flush();
            }

            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
