public class Lab29 {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                break;
            } else {
                System.out.println("i=" + i);
            }
        }

        System.out.println();

        for (int j = 0; j <= 10; j++) {
            if (j == 5) {
                continue;
            } else {
                System.out.println("j=" + j);
            }
        }

    }
}