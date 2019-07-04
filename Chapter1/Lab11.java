import java.util.Scanner;

public class Lab11 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// P.43 Lab1
		System.out.println("input 5 numbers with separate blank_space");
		int lab0 = keyboard.nextInt();
		int lab1 = keyboard.nextInt();
		int lab2 = keyboard.nextInt();
		int lab3 = keyboard.nextInt();
		int lab4 = keyboard.nextInt();
		System.out.println((lab0 + lab1 + lab2 + lab3 + lab4) / 5);
	}
}
