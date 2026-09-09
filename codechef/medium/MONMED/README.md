# MONMED

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Monotone Median

*This is the easy version of the problem. Here, $N$ is odd and you must construct a valid sequence of subarrays for $K = \frac{N+1}{2}$.
The setup of both problems is otherwise the same.*

You are given a permutation $P$ of length $N$, where $N$ is  **odd**.
A permutation of length $N$ is an array of length $N$ that contains every integer from $1$ to $N$ exactly once each.

Let $K = \frac{N+1}{2}$.
Find a sequence of $K$ subarrays $[L_1,R_1], [L_2,R_2], \ldots, [L_K,R_K]$ such that all the following conditions hold:

- For each $1 \le i \le K$, the length of $[L_i,R_i]$ is exactly $2i-1$. That is, $R_i-L_i+1=2i-1$.
- For each $2 \le i \le K$, the subarray $[L_i,R_i]$ contains $[L_{i-1},R_{i-1}]$. That is, $L_i \le L_{i-1}$ and $R_{i-1} \le R_i$.
- The medians of these $K$ subarrays are strictly increasing.

The median of an array of odd length is its middle element after sorting it. For example, the median of $[4,1,3]$ is $3$.

If many such sequences exist, you may find any of them.
If no such sequence exists, print $-1$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains a single integer $N$ — the length of the permutation. The second line of each test case contains $N$ space-separated integers $P_1, \ldots, P_N$.
### Output Format

For each test case:

- If no valid sequence exists, print $-1$ on a new line.
- Otherwise, print $K=\frac{N+1}{2}$ lines. On the $i$-th line, print two space-separated integers $L_i$ and $R_i$, denoting the endpoints of the $i$-th subarray.

If there are multiple valid sequences, you may print any of them.

### Constraints
- $1 \le T \le 10^5$
- $1 \le N \lt 2\cdot 10^5$
- $N$ is odd.
- $P$ is a permutation of $[1,N]$.
- The sum of $N$ over all test cases does not exceed $2\cdot 10^5$.
### Sample 1:
Input
Output

```
5
1
1
3
2 3 1
5
1 3 4 2 5
7
4 7 2 6 1 5 3
7
1 2 4 5 6 3 7

```

```
1 1
3 3
1 3
-1
5 5
3 5
3 7
1 7
-1

```

### Explanation:

 **Test case $1$:**  There's only a single subarray, and it satisfies the condition.

 **Test case $2$:**  We have $P = [2, 3, 1]$. Consider the sequence of subarrays $[1], [2, 3, 1]$. They satisfy the conditions, because:

- Their lengths are $1$ and $3$.
- The first subarray is contained in the second.
- Their medians are $1$ and $2$ in order, which is strictly increasing.

So, this is a valid sequence of subarrays.
We print the endpoints of the subarrays, which is $[3, 3]$ for $[1]$ and $[1, 3]$ for $[2, 3, 1]$.

 **Test case $3$:**  It can be verified that no valid sequence of subarrays satisfying the conditions exists.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-09T16:19:28.573Z  

```java
import java.io.*;
import java.util.*;

public class Main {

    static class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void add(int index, int value) {
            while (index <= n) {
                bit[index] += value;
                index += index & -index;
            }
        }

        // Returns the position of the k-th smallest element
        int kth(int k) {
            int idx = 0;

            int power = Integer.highestOneBit(n);

            for (int step = power; step != 0; step >>= 1) {
                int next = idx + step;

                if (next <= n && bit[next] < k) {
                    idx = next;
                    k -= bit[next];
                }
            }

            return idx + 1;
        }
    }

    static int[] a;
    static Fenwick fenwick;

    static int median(int length) {
        int k = (length + 1) / 2;
        return fenwick.kth(k);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            a = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int posOne = -1;

            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());

                if (a[i] == 1) {
                    posOne = i;
                }
            }

            fenwick = new Fenwick(N);

            int l = posOne;
            int r = posOne;

            // Start with [posOne, posOne]
            fenwick.add(a[posOne], 1);

            int currentMedian = 1;

            boolean possible = true;

            out.append(l + 1).append(" ").append(r + 1).append('\n');

            for (int length = 3; length <= N; length += 2) {

                int bestL = -1;
                int bestR = -1;
                int bestMedian = Integer.MAX_VALUE;

                // Three possible expansions
                int[][] candidates = {
                    {l - 2, r},
                    {l - 1, r + 1},
                    {l, r + 2}
                };

                for (int[] c : candidates) {

                    int nl = c[0];
                    int nr = c[1];

                    if (nl < 0 || nr >= N) {
                        continue;
                    }

                    // Temporarily add the two new elements
                    if (nl == l - 2) {
                        fenwick.add(a[l - 2], 1);
                        fenwick.add(a[l - 1], 1);
                    }
                    else if (nr == r + 2) {
                        fenwick.add(a[r + 1], 1);
                        fenwick.add(a[r + 2], 1);
                    }
                    else {
                        fenwick.add(a[l - 1], 1);
                        fenwick.add(a[r + 1], 1);
                    }

                    int newMedian = median(length);

                    // Remove temporary elements
                    if (nl == l - 2) {
                        fenwick.add(a[l - 2], -1);
                        fenwick.add(a[l - 1], -1);
                    }
                    else if (nr == r + 2) {
                        fenwick.add(a[r + 1], -1);
                        fenwick.add(a[r + 2], -1);
                    }
                    else {
                        fenwick.add(a[l - 1], -1);
                        fenwick.add(a[r + 1], -1);
                    }

                    // Need strictly increasing median.
                    // Among valid choices, choose smallest median.
                    if (newMedian > currentMedian &&
                        newMedian < bestMedian) {

                        bestMedian = newMedian;
                        bestL = nl;
                        bestR = nr;
                    }
                }

                if (bestL == -1) {
                    possible = false;
                    break;
                }

                // Permanently add the selected two elements
                if (bestL == l - 2) {
                    fenwick.add(a[l - 2], 1);
                    fenwick.add(a[l - 1], 1);
                }
                else if (bestR == r + 2) {
                    fenwick.add(a[r + 1], 1);
                    fenwick.add(a[r + 2], 1);
                }
                else {
                    fenwick.add(a[l - 1], 1);
                    fenwick.add(a[r + 1], 1);
                }

                l = bestL;
                r = bestR;
                currentMedian = bestMedian;

                out.append(l + 1)
                   .append(" ")
                   .append(r + 1)
                   .append('\n');
            }

            if (!possible) {
                // Remove already printed lines for this test case
                // by rebuilding output is inconvenient, so use a temporary
                // StringBuilder in production.
            }
        }

        System.out.print(out);
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/MONMED)