
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] max = new int[9];

            for (int i = 0; i < n; i++) {
                int p = sc.nextInt();
                int s = sc.nextInt();

                if (p <= 8) {
                    max[p] = Math.max(max[p], s);
                }
            }

            int total = 0;

            for (int i = 1; i <= 8; i++) {
                total += max[i];
            }

            System.out.println(total);
        }

        sc.close();
    }
}
