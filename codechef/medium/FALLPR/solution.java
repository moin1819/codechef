import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            long[] A = new long[N];
            long[] prefix = new long[N + 1];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextLong();
                prefix[i + 1] = prefix[i] + A[i];
            }

            // prefixMin[i] = minimum prefix sum from 0 to i
            long[] prefixMin = new long[N + 1];
            prefixMin[0] = prefix[0];

            for (int i = 1; i <= N; i++) {
                prefixMin[i] = Math.min(prefixMin[i - 1], prefix[i]);
            }

            // suffixMin[i] = minimum prefix sum from i to N
            long[] suffixMin = new long[N + 1];
            suffixMin[N] = prefix[N];

            for (int i = N - 1; i >= 0; i--) {
                suffixMin[i] = Math.min(prefix[i], suffixMin[i + 1]);
            }

            boolean possible = false;

            // Try deleting A[j]
            for (int j = 0; j < N; j++) {

                // Prefixes before A[j] must already be non-negative
                boolean leftGood = prefixMin[j] >= 0;

                // After deleting A[j]:
                // new prefix = prefix[i] - A[j]
                boolean rightGood =
                        suffixMin[j + 1] - A[j] >= 0;

                if (leftGood && rightGood) {
                    possible = true;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }

        sc.close();
    }
}