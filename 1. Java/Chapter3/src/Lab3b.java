import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Lab3b {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

            writer.println("Dear Alan.");
            writer.println("How are you?");
            writer.println("Joe");

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}