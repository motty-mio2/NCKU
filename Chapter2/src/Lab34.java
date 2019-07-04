import java.util.Scanner;

public class Lab34 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please input a value for x:");
        int x = keyboard.nextInt();
        System.out.print("Please input a value for n:");
        int n = keyboard.nextInt();

        System.out.println("y = " + n * x * x);

    }
}