import java.util.Scanner;

public class Lab35 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please input a value for a:");
        int a = keyboard.nextInt();
        System.out.print("Please input a value for b:");
        int b = keyboard.nextInt();
        System.out.print("Please input a value for c:");
        int c = keyboard.nextInt();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Equatation is wrong!");
            } else if (c == 0) {
                System.out.println("ans is 0");
            }
        } else {
            int tmp = b * b - 4 * a * c;
            if (tmp < 0) {
                System.out.println("ans is Imaginary num");
            } else if (tmp == 0) {
                System.out.println("ans is " + -b / 2 * a);
            } else {
                double sqtmp = Math.sqrt(tmp);
                System.out.println("ans is " + (-b + sqtmp) / 2 * a + " and " + (-b - sqtmp) / 2 * a);
            }
        }
    }
}