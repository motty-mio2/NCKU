import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lab3a {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream("text.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}