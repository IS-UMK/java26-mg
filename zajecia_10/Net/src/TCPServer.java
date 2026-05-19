import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    static void main() {
        try {

            ServerSocket server = new ServerSocket(12345);
            server.setSoTimeout(100_000);
            while (true) {
                System.out.println("Waiting for connection...");
                Socket client = server.accept();
                System.out.println("Accepted connection from: " + client.getRemoteSocketAddress());

                new Thread(() -> run(client)).start();
            }

        }catch (IOException e) {
            System.err.println("Could not listen on port: 12345\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }

    }

    public static void run(Socket client) {

        try(client; BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        ){
                String text = in.readLine();
                System.out.println("Otrzymany komunikat:" + text);

                out.println("ECHO: " + text);
        }catch(IOException e) {
            System.err.println("Could not listen on port: 12345\n" + e.getMessage());
        }
    }
}
