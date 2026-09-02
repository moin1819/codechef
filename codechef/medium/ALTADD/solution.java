import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            long[] B = new long[N];

            for (int i = 0; i < N; i++) {
                long x = sc.nextLong();

                // Alternate signs
                if (i % 2 == 0) {
                    B[i] = x;
                } else {
                    B[i] = -x;
                }
            }

            long total = Math.abs(B[0]);

            for (int i = 1; i < N; i++) {
                total += Math.abs(B[i] - B[i - 1]);
            }

            total += Math.abs(B[N - 1]);

            System.out.println(total / 2);
        }

        sc.close();
    }
}