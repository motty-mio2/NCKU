import java.util.Scanner;

public class Lab33 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please input a number :");
        int x = keyboard.nextInt();
        int ans = x;

        for (int i = x - 1; i > 0; i--) {
            ans *= i;
        }

        System.out.println(x + "!=" + ans);

    }
}