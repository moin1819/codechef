
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                int score = (a[i] * 20) - (b[i] * 10);

                if (score < 0) {
                    score = 0;
                }

                max = Math.max(max, score);
            }

            System.out.println(max);
        }

        sc.close();
    }
}
