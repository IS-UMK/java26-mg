import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {


        String address = "127.0.0.1";
        int port = 12345;

        try(Socket socket = new Socket(address, port);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        )
        {
            out.println("PING");
            System.out.println(in.readLine());
        }catch(IOException e){
            System.out.println("Error:" + e);
        }

    }
}
