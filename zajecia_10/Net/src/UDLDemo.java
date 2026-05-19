import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDLDemo {


    static void main() {
        try {
            URL url = new URL("https://fizyka.umk.pl:443/~grochu/wiki/doku.php?do=export_revealjs&id=zajecia:java:10_net&theme=simple&disableLayout=0&transition=none&controls=true&show_progress_bar=1&build_all_lists=0&show_image_borders=0&horizontal_slide_level=2&enlarge_vertical_slide_headers=0&size=1024x768#/16");
            System.out.println(url.getProtocol()); // https
            System.out.println(url.getHost());     // example.com
            System.out.println(url.getPath());     // /api/users
            System.out.println(url.getQuery());    // page=1
            System.out.println(url.getPort());     // -1 (domyślny port)
            System.out.println(url.getDefaultPort()); // 443
            System.out.println(url.getFile());      // /api/users?page=1
            System.out.println(url.getRef());       // null (część po #)
            System.out.println(url.getAuthority()); // example.com

            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            String content = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(content);




        } catch(IOException e) {
            System.out.println("Bąd pooączenia:" + e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
