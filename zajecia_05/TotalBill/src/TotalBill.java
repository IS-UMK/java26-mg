import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TotalBill {

    public static void main(String[] args) {

        Path path = Path.of("tips.csv");
        try (Stream<String> lines = Files.lines(path)) {
       // lines.forEach(System.out::println);

            Map<String, List<String[]>> collect = lines.skip(1).map(s -> s.split(","))
                    .collect(Collectors.groupingBy(strings -> strings[2]) );

            for(Map.Entry<String, List<String[]>> entry : collect.entrySet()) {
                double avgBySex = entry.getValue().stream().mapToDouble(s->Double
                        .parseDouble(s[0])).average().orElse(0);
                System.out.println(entry.getKey() + " " + avgBySex);
            }
        }catch (IOException e)
        {
            System.err.println("Problem odczytu pliku");
            System.err.println(e.getMessage());
        }
    }
}
