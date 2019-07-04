@@ -1,132 +0,0 @@
package Hello1;

import java.util.Scanner;

import javax.security.auth.kerberos.KerberosCredMessage;

public class Hello {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		int answer;
		answer = 2 + 2;
		System.out.println("2 + 2 is " + answer);

		int x = 30;
		int y = 20;

		System.out.println(x * y + 9 / 3);
		System.out.println(x / y * 5);

		System.out.println(15 / 2);
		System.out.println(15.0 / 2);

		int a = 10;
		int b = 3;
		double c = 10 / 3;
		double d = 10 / (double) 3;
		System.out.println(c);
		System.out.println(d);

		String blessing = "Live long and prosper";
		System.out.println(blessing);
		System.out.println(blessing.length());
		System.out.println(blessing.equals("Live long and prosper"));
		System.out.println(blessing.equals("Live long and Prosper"));
		System.out.println(blessing.equalsIgnoreCase("Live long and Prosper"));

		System.out.println();

		String hellol = "HELLO";
		String hellos = "hello";

		System.out.println("hellos".toUpperCase());
		System.out.println("hellol".toLowerCase());

		System.out.println();

		String sampleH = "     H   e l  l o  ";
		System.out.println(sampleH);
		System.out.println(sampleH.trim());
		System.out.println("  ".trim() + "\n");

		// System.out.println("Hello".charAtjava(0));

		String sampleA = "AbcdefG";
		/*
		 * int circle = sampleA.length(); int i = 0 fot (i = 0; i < circle; i++){
		 * System.out.println(sampleA.charAt(i)); }
		 */

		System.out.println(sampleA);
		System.out.println(sampleA.substring(2));
		System.out.println(sampleA.substring(2, 5));

		System.out.println(sampleA.indexOf("c"));
		System.out.println(sampleA.indexOf("C"));

		// P.33 Lab
		String str = "Java Programming!";
		System.out.println(str.equals("Java Programming!"));
		System.out.println(str.toLowerCase()); // java programming!
		System.out.println(str.toUpperCase()); // JAVA PROGRAMMING!
		System.out.println(str.substring(5, 8)); // Pro
		System.out.println(str.lastIndexOf("m")); // 12

		Scanner keyboard = new Scanner(System.in);

		/*
		 * System.out.print("Lets add first and second!\nInput 1stnumber:"); int inA =
		 * keyboard.nextInt(); System.out.print("Input 2ndnumber:"); int inB =
		 * keyboard.nextInt(); System.out.println(inA + inB);
		 *
		 * System.out.print("Lets add first and second!\nInput two numbers:"); inA, inB
		 * = keyboard.nextInt(); System.out.println(inA + inB);
		 */

		// P.44 Lab
		System.out.print("input a number:");
		String line1 = keyboard.nextLine();
		int num = Integer.valueOf(line1);
		System.out.println("num=" + num);
		System.out.print("input a string:");
		String line2 = keyboard.nextLine();
		System.out.println("Line:" + line2);

		Scanner keyboard2 = new Scanner(System.in);
		keyboard2.useDelimiter("##");

		// P.42 Lab
		System.out.println("input -> (num)##(num)##");
		a = keyboard2.nextInt();
		b = keyboard2.nextInt();
		System.out.println(a);
		System.out.println(b);

		// P.43 Lab1
		System.out.println("input 5 numbers with separate blank_space");
		int lab0 = keyboard.nextInt();
		int lab1 = keyboard.nextInt();
		int lab2 = keyboard.nextInt();
		int lab3 = keyboard.nextInt();
		int lab4 = keyboard.nextInt();
		System.out.println((lab0 + lab1 + lab2 + lab3 + lab4) / 5);

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

public class Hello2 {

	public static void main(String[] args) {
		System.out.println("Hello");
	}
}