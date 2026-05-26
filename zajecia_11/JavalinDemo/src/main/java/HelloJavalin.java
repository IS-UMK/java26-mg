import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.Map;

record User(int id, String name, String email) {}


public class HelloJavalin {


    static void main() {



        Javalin app = Javalin.create(




                config -> {

                    config.staticFiles.add("/public", Location.CLASSPATH);
                   //config.routes.get("/",
                    //        ctx -> ctx.result("Hello World!"));


                    config.routes.get("/headers", ctx -> {

                        String userAgent = ctx.header("User-Agent");
                        String contentType = ctx.header("Content-Type");

                        ctx.result("User-Agent: " + userAgent);

                        Map<String,String> headers = ctx.headerMap();

                        for (String key : headers.keySet()) {
                            System.out.println(key + ": " + headers.get(key));
                        }



                    });

                    config.routes.get("/user", ctx -> {
                        User user = new User(1, "Alice", "alice@example.com");
                        ctx.json(user); // Automatyczna konwersja do JSON
                    });

                    config.routes.exception(RuntimeException.class, (e, ctx) -> {
                        ctx.status(500);
                        ctx.result("Blad serwera: " + e.getMessage());
                    });

                    config.routes.get("/boom", ctx -> {
                        throw new RuntimeException("DEMO: kontrolowany wyjątek");
                    });


                    config.routes.post("/echo", ctx -> {
                        String body = ctx.body();
                        ctx.result("Echo: " + body);
                    });


                    config.routes.get("/users/{id}/posts/{postId}", ctx -> {

                        String userId = ctx.pathParam("id");

                        // Z walidacją typu
                        int postId = ctx.pathParamAsClass("postId", Integer.class).get();

                        ctx.result("User: " + userId + ", Post: " + postId);
                    });

                    config.routes.get("/search", ctx -> {

                        String query = ctx.queryParam("q");
                        int limitInt = ctx.queryParamAsClass("limit", Integer.class).getOrDefault(42);

                        ctx.result("Szukam: " + query + " (limit: " + limitInt + ")");
                    });
/*
                    config.routes.get("/admin/users", ctx -> ctx.result("Admin users")); // Konkretna
                    config.routes.get("/admin/*", ctx -> ctx.result("Admin section"));   // Ogólna
                    config.routes.get("/*", ctx -> ctx.result("Everything else"));       // N
*/



                }
        );

        app.start(8080);
    }

}
