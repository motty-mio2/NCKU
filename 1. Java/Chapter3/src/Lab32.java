import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab31 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);

            System.out.print("Please input the path of output file :");
            String fileph = keyboard.nextLine();
            PrintWriter writer = new PrintWriter(new FileOutputStream(fileph));

            System.out.print("Please input the number of height and width :");
            int nums = keyboard.nextInt();

            for (int i = 0; i < nums; i++) {
                for (int j = 0; j < nums; j++) {
                    writer.print("*");
                }
                writer.println();
            }

            writer.flush();
            writer.close();
            System.out.println("finish!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}