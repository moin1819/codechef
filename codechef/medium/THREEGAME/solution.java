import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();

            if (N == 1) {
                System.out.println(1);
            } else {
                System.out.println(2 * N);
            }
        }

        sc.close();
    }
}