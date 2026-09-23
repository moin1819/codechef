import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();
            long A = sc.nextLong();
            long B = sc.nextLong();
            long C = sc.nextLong();

            long ans = Long.MAX_VALUE;

            // Case 1:
            // Use one spray to cover the entire house.
            // X = 1, Y = N, Z = 1
            ans = Math.min(ans, A + B * N + C);

            // For B * X >= C, optimal Y is X.
            long startX = (C + B - 1) / B;
            startX = Math.max(1, startX);

            for (long X = startX; X <= N; X++) {
                long Y = X;

                // Number of sprays / required linger period
                long Z = (N + X - 1) / X;

                long cost = A * X + B * Y + C * Z;

                ans = Math.min(ans, cost);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}