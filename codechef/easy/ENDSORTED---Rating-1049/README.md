# ENDSORTED - Rating 1049

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### End Sorted

Chef considers a permutation $P$ of $\{1, 2, 3, \dots, N\}$ `End Sorted` if and only if $P_1 = 1$ and $P_N = N$.

Chef is given a permutation $P$.

In one operation Chef can choose any index $i \ (1 \leq i \leq N-1)$ and swap $P_i$ and $P_{i+1}$. Determine the minimum number of operations required by Chef to make the permutation $P$ `End Sorted`.

 **Note:**  An array $P$ is said to be a permutation of $\{1, 2, 3, \dots, N\}$ if $P$ contains each element of $\{1, 2, 3, \dots, N\}$ exactly once.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains a single integer $N$, denoting the length of the permutation $P$. The second line contains $N$ space-separated integers $P_1, P_2, P_3, \ldots, P_N$, denoting the permutation $P$.
### Output Format

For each test case, output minimum number of operations required by Chef to make the permutation $P$ `End Sorted`.

### Constraints
- $1 \leq T \leq 1000$
- $2 \leq N \leq 10^5$
- $P$ is a permutation of $\{1, 2, 3, \dots N\}$
- The sum of $N$ over all test cases does not exceed $3 \cdot 10^5$.
### Sample 1:
Input
Output

```
4
4
1 3 2 4
3
3 2 1
2
2 1
3
2 1 3

```

```
0
3
1
1

```

### Explanation:

 **Test case $1$:**  $P$ is already `End Sorted`.

 **Test case $2$:**  $P$ can be made `End Sorted` using $3$ operations as follows: $[3, 2, 1] \to [\textcolor{red}{2, 3}, 1] \to [2, \textcolor{red}{1, 3}] \to [\textcolor{red}{1, 2}, 3]$. It can be shown that achieving this in fewer than $3$ moves is impossible.

 **Test case $3$:**  $P$ can be made `End Sorted` using one operation, by swapping $1$ and $2$.

 **Test case $4$:**  $P$ can be made `End Sorted` using one operation, by swapping $1$ and $2$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-26T15:36:43.118Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int pos1 = 0, posN = 0;

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                if (x == 1) {
                    pos1 = i;
                }
                if (x == N) {
                    posN = i;
                }
            }

            int ans = pos1 + (N - 1 - posN);

            if (pos1 > posN) {
                ans--;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/ENDSORTED)