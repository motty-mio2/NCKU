import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

public class Lab31 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream("input.txt"));
            PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.trim();
                int len = line.length();
                for (int i = 0; i < len; i++) {
                    String target = line.substring(i, i + 1);
                    switch (target) {
                    case "a":
                    case "i":
                    case "u":
                    case "e":
                    case "o":
                        writer.print(target.toUpperCase());
                        break;
                    default:
                        writer.print(target.toLowerCase());
                    }
                }
                writer.println();
            }

            Date date = new Date();
            String stdate = date.toString();
            writer.print("\n" + stdate.substring(4, 10));

            writer.flush();
            writer.close();
            System.out.println("finish!");

        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}