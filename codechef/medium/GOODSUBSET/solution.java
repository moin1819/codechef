import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 998244353L;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        int T = sc.nextInt();

        int[] queries = new int[T];
        int maxN = 0;

        for (int i = 0; i < T; i++) {
            queries[i] = sc.nextInt();
            maxN = Math.max(maxN, queries[i]);
        }

        // Modular inverses
        long[] inv = new long[maxN + 1];

        if (maxN >= 1) {
            inv[1] = 1;
        }

        for (int i = 2; i <= maxN; i++) {
            inv[i] = MOD - (MOD / i) * inv[(int)(MOD % i)] % MOD;
        }

        for (int N : queries) {
            solve(N, inv);
        }
    }

    static void solve(int N, long[] inv) {

        // Groups according to highest set bit.
        // For N = 10:
        // [1], [2,3], [4,5,6,7], [8,9,10]
        ArrayList<Integer> groups = new ArrayList<>();

        int p = 1;

        while (p <= N) {
            int size = Math.min(p, N - p + 1);
            groups.add(size);
            p *= 2;
        }

        int maxGroup = groups.get(groups.size() - 1);

        // Number of all subsets
        long totalSubsets = modPow(2, N);

        /*
         * For each group:
         * choose = C(c, 0)
         * prefix = C(c,0) + ... + C(c,k-1)
         */
        long[] choose = new long[groups.size()];
        long[] prefix = new long[groups.size()];

        Arrays.fill(choose, 1);
        Arrays.fill(prefix, 1);

        long answer = 0;

        // k = 1 ... maxGroup
        for (int k = 1; k <= maxGroup; k++) {

            // Add C(groupSize, k-1) to each prefix.
            for (int g = 0; g < groups.size(); g++) {

                int c = groups.get(g);

                if (k - 1 <= c) {
                    if (k - 1 > 0) {
                        // C(c, k-1) from C(c, k-2)
                        choose[g] = choose[g]
                                * (c - (k - 2))
                                % MOD
                                * inv[k - 1]
                                % MOD;
                    }

                    prefix[g] += choose[g];

                    if (prefix[g] >= MOD) {
                        prefix[g] -= MOD;
                    }
                }
            }

            // Product of prefix values
            long bad = 1;

            for (long value : prefix) {
                bad = bad * value % MOD;
            }

            // Number of subsets with f(S) >= k
            long good = (totalSubsets - bad + MOD) % MOD;

            answer += good;

            if (answer >= MOD) {
                answer -= MOD;
            }
        }

        System.out.println(answer);
    }

    static long modPow(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }

    // Fast input
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return result * sign;
        }
    }
}