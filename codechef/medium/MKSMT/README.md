# MKSMT

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Smoothen

For an array $B$ of length $M$, and an integer $X$, define  *smoothing*  b with respect to $X$ as follows:

- Start with $S = 0$
- For each $i = 1, 2, 3, \ldots, M$ in order: If $B_i \ge X$, add $B_i - X$ to $S$ and set $B_i = X$. If $B_i \lt X$, add $\min(S, X-B_i)$ to $B_i$ and subtract the same value from $S$.

Note that $S$ may be positive in the end, but that's fine - we don't do anything with this "extra" value.

For example, if $B = [4, 6, 1, 5, 1]$,

- Smoothing it with $X = 2$ will result in $[2, 2, 2, 2, 2]$.
- Smoothing it with $X = 4$ will result in $[4, 4, 3, 4, 2]$.

You're given an array $A$.
Find the  **largest**  positive integer $X$ such that there exists a pair of integers $(L, R)$ ($1 \le L \le R \le N$) satisfying the following:

- If the subarray of $A$ from index $L$ to index $R$ is smoothed by $X$, the entire array $A$ becomes sorted in non-decreasing order.

If there are arbitrarily large values of $X$ that can cause $A$ to become sorted after smoothing a subarray, print $-1$ instead.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains a single integer $N$ — the length of the array. The second line contains $N$ space-separated integers $A_1, \ldots, A_N$.
### Output Format

For each test case, on a new line:

- If there's no finite maximum $X$, print $-1$.
- Otherwise print the maximum valid $X$.
### Constraints
- $1 \leq T \leq 10^5$
- $1 \leq N \leq 2\cdot 10^5$
- $1 \le A_i \le 10^9$
- The sum of $N$ over all test cases won't exceed $2\cdot 10^5$.
### Sample 1:
Input
Output

```
3
4
2 4 4 7
5
2 7 3 3 9
6
1 2 10 3 4 20

```

```
-1
4
5

```

### Explanation:

 **Test case $1$:**  The array is already sorted, so any value of $X$ is valid (for example by choosing $L=R=1$ always). There is no finite maximum valid $X$, so we output $-1$.

 **Test case $2$:**  We have $A = [2, 7, 3, 3, 9]$. Consider choosing $X = 4, L = 2, R = 4$.

- We want to smoothen the subarray $[7, 3, 3]$ with respect to $4$. This will occur as follows:
- Initially, $S = 0$.
- When processing $7$, we add $7-4 = 3$ to $S$ and then set the $7$ to $4$. The subarray is now $[4, 3, 3]$.
- When processing the first $3$, we add $1$ to it and subtract $1$ from $S$. The subarray is now $[4, 4, 3]$ and $S = 2$.
- When processing the second $3$, we again add $1$ to it and subtract $1$ from $S$. The subarray is now $[4, 4, 4]$ and $S = 1$.

After smoothing this subarray, the array is $[2, 4, 4, 4, 9]$ which is sorted.

It can be verified that for any $X \gt 4$, no choice of subarray can make the array sorted; so the answer is $4$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T16:15:42.438Z  

```java
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

```

---

[View on CodeChef](https://www.codechef.com/problems/MKSMT)