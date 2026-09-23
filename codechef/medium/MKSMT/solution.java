import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your coimport java.util.*;

class Main {

    static int N;
    static long[] A;

    static boolean isSorted() {
        for (int i = 1; i < N; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static boolean possible(long X) {

        // Find the first and last inversion.
        int firstBad = -1;
        int lastBad = -1;

        for (int i = 0; i < N - 1; i++) {
            if (A[i] > A[i + 1]) {
                if (firstBad == -1) {
                    firstBad = i;
                }
                lastBad = i;
            }
        }

        // Array is already sorted.
        if (firstBad == -1) {
            return true;
        }

        /*
         * Before firstBad the array is already sorted.
         *
         * We need to start at the first position whose value
         * is >= X. Its previous value, if any, must be <= X.
         */
        int L = -1;

        for (int i = 0; i <= firstBad; i++) {
            if (A[i] >= X) {
                L = i;
                break;
            }
        }

        if (L == -1) {
            return false;
        }

        if (L > 0 && A[L - 1] > X) {
            return false;
        }

        /*
         * We must include the last inversion.
         *
         * After the smoothing segment, the next element must
         * be >= X. Since the suffix after lastBad is sorted,
         * extend R until the next element is >= X.
         */
        int R = lastBad + 1;

        while (R < N - 1 && A[R + 1] < X) {
            R++;
        }

        /*
         * Check that the amount of "excess" is never negative.
         *
         * If prefix sum of (A[i] - X) becomes negative,
         * there isn't enough excess to raise the elements
         * to X.
         */
        long sum = 0;

        for (int i = L; i <= R; i++) {
            sum += A[i] - X;

            if (sum < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();

            A = new long[N];

            long maxA = 0;

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextLong();
                maxA = Math.max(maxA, A[i]);
            }

            // Already sorted => arbitrarily large X works.
            if (isSorted()) {
                System.out.println(-1);
                continue;
            }

            long low = 1;
            long high = maxA;
            long answer = 1;

            while (low <= high) {
                long mid = low + (high - low) / 2;

                if (possible(mid)) {
                    answer = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }
}de goes here

	}
}
