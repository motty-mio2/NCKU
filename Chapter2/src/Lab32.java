import java.util.Random;

public class Lab32 {
    public static void main(String[] args) {

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt(40);
            System.out.println(i + " : " + x);
        }
    }
}