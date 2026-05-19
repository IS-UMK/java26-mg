import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class InetAddressTest {

    static void main() {

        try {
            InetAddress inet = InetAddress.getLocalHost();
            System.out.println("Local host: " + inet.getHostName());
            System.out.println("Local host address: " + inet.getHostAddress());
            System.out.println("Local host name: " + inet.getHostName());
            System.out.println("Full name: " + inet.getCanonicalHostName());

            System.out.println("Podaj adres:");
            String address;
            try (var reader = new BufferedReader(new InputStreamReader(System.in))) {

                address = reader.readLine();

                InetAddress inet2 = InetAddress.getByName(address);
                System.out.println("Nazwa hosta:" + inet2.getHostName());
                System.out.println("Adres hosta:" + inet2.getHostAddress());
                for(var adr: InetAddress.getAllByName(address))
                    System.out.println("Address: " + adr.getHostAddress());
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
