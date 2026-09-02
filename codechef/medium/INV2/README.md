# INV2

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Inversions II

Let $f(A)$ denote the maximum value of $A_i + A_j$ such that $1 \le i < j \le |A|$ and $A_i > A_j$. If no such valid pair exists, $f(A)$ is $0$.

Given $N$, find the sum of $f(A)$ over all permutations of $[1, N]$ modulo $998244353$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- The first and only line of each test case contains a single integer $N$.
### Output Format

For each test case, output the sum of $f(A)$ over all permutations modulo $998244353$.

### Constraints
- $1 \le T \le 100$
- $2 \le N \le 2 \cdot 10^5$
- The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.
### Sample 1:
Input
Output

```
4
2
3
4
100

```

```
3
22
140
504678165

```

### Explanation:

 **Test Case 1:**  $f([1, 2]) = 0$ because there is no valid pair, and $f([2, 1]) = 3$ because $(i, j) = (1, 2)$ is valid with $A_i + A_j = 3$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-02T15:41:26.128Z  

```java
import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 998244353L;

    static long[] fact;
    static long[] inv;
    static long[] doubleFact;
    static long[] invDoubleFact;

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int T = fs.nextInt();

        int[] queries = new int[T];
        int maxN = 0;

        for (int i = 0; i < T; i++) {
            queries[i] = fs.nextInt();
            maxN = Math.max(maxN, queries[i]);
        }

        precompute(maxN);

        for (int N : queries) {
            solve(N);
        }
    }

    static void precompute(int maxN) {

        // Factorials
        fact = new long[maxN + 1];
        fact[0] = 1;

        for (int i = 1; i <= maxN; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // Modular inverses
        inv = new long[maxN + 1];

        if (maxN >= 1) {
            inv[1] = 1;
        }

        for (int i = 2; i <= maxN; i++) {
            inv[i] = MOD - (MOD / i) * inv[(int)(MOD % i)] % MOD;
        }

        // Double factorial
        doubleFact = new long[maxN + 1];
        invDoubleFact = new long[maxN + 1];

        doubleFact[0] = 1;

        for (int i = 1; i <= maxN; i++) {
            doubleFact[i] = doubleFact[i - 1];

            if (i % 2 == 1) {
                // i!! = i * (i-2)!!
                if (i == 1) {
                    doubleFact[i] = 1;
                } else {
                    doubleFact[i] = (long) i * doubleFact[i - 2] % MOD;
                }
            } else {
                if (i == 2) {
                    doubleFact[i] = 2;
                } else {
                    doubleFact[i] = (long) i * doubleFact[i - 2] % MOD;
                }
            }
        }

        // Inverse double factorial
        invDoubleFact[0] = 1;

        for (int i = 1; i <= maxN; i++) {
            invDoubleFact[i] = modPow(doubleFact[i], MOD - 2);
        }
    }

    static void solve(int N) {

        long totalPermutations = fact[N];

        // Maximum possible f(A) = 2N - 1
        long answer = ((2L * N - 1) % MOD) * totalPermutations % MOD;

        /*
         * Subtract number of permutations having f(A) <= s
         * for s = 0 ... 2N-2
         */
        long sumCDF = 0;

        for (int s = 0; s <= 2 * N - 2; s++) {

            long cnt;

            if (s <= 2) {
                // Only the completely sorted permutation
                cnt = 1;
            }
            else if (s < N) {
                // C_s = (s-1)!!
                cnt = doubleFact[s - 1];
            }
            else {
                // C_s = N! / (2N-s)!!
                int d = 2 * N - s;

                cnt = fact[N] * invDoubleFact[d] % MOD;
            }

            sumCDF += cnt;

            if (sumCDF >= MOD) {
                sumCDF -= MOD;
            }
        }

        answer = (answer - sumCDF + MOD) % MOD;

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

        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
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

            int result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return result;
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/INV2)