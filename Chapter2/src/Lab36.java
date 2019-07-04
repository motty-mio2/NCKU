import java.util.Scanner;

public class Lab36 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("input two Numbers, they have to have same length");
        System.out.print("1st : ");
        String n1 = keyboard.nextLine();
        System.out.print("2nd : ");
        String n2 = keyboard.nextLine();

        int lens = n1.length();
        int A = 0;
        int B = 0;

        for (int i = 0; i < lens; i++) {
            if (n1.charAt(i) == n2.charAt(i)) {
                A++;
            } else {
                for (int j = 0; j < lens; j++) {
                    if (n1.charAt(i) == n2.charAt(j)) {
                        if (i == j) {
                            continue;
                        } else {
                            B++;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(A + "A" + B + "B");
    }
}