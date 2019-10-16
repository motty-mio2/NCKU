import java.util.Scanner;

public class Lab12 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// P.44 Lab
		System.out.print("Now in Lab at P.44\ninput a num:");
		int p = keyboard.nextInt();

		System.out.println("input 3 nums with balnk_space:");
		int lab5 = keyboard.nextInt();
		int lab6 = keyboard.nextInt();
		int lab7 = keyboard.nextInt();
		System.out.println((int) (Math.pow(lab5, p) + Math.pow(lab6, p) + Math.pow(lab7, p)));
	}
}
