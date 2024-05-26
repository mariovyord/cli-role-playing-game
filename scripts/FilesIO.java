package scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FilesIO {
    public static void main(String[] args) {
        var names = new String[] { "Alice", "Bob", "Charlie" };

        // writing to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./scripts/log.txt"))) {
            writer.write("Hello, world \n");

            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // reading from file
        try (BufferedReader reader = new BufferedReader(new FileReader("./scripts/log.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        File f = new File("test-file.txt");
        System.out.println(f.exists());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getName());
    }
}
