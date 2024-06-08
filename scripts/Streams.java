package scripts;

import java.util.List;
import java.util.stream.Collectors;

// Example for Java Streams
public class Streams {

    List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah", "Ivan",
            "Julia");

    public void start() {

        List<String> nameWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Names with A: " + nameWithA);

        nameWithA = null;
        System.gc();
    }

    public void finalize() {
        System.out.println("Object is destroyed!");

    }
}
