import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab31 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream("inlab31.txt"));
            PrintWriter writer = new PrintWriter(new FileOutputStream("outlab31.txt"));

            String line = scanner.nextLine();

            writer.println(line.toUpperCase());
            writer.println(line.toLowerCase());

            writer.flush();
            writer.close();
            System.out.println("finish!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}