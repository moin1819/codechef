# COUNTP - Rating 1065

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Counting Problem

You are given an array $A = [A_1, A_2, \ldots, A_N]$.

Is it possible to partition $A$ into two non-empty subsequences $S_1$ and $S_2$ such that $sum(S_1) \times sum(S_2)$ is  **odd** ?

Here, $sum(S_1)$ denotes the sum of elements in $S_1$, and $sum(S_2)$ is defined similarly.

 **Note:**  $S_1$ and $S_2$ must  *partition*  $A$, that is:

- $S_1$ and $S_2$ must be non-empty
- Every element of $A$ must be in either $S_1$ or $S_2$
- $S_1$ and $S_2$ must be disjoint (in terms of which indices their subsequences represent)
### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of 2 lines of input. The first line of each test case contains a single integer $N$, the size of the array. The next line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$: the elements of the array.
### Output Format

For each test case, print on a new line the answer: `YES` if the array can be partitioned into two subsequences satisfying the condition, and `NO` otherwise.

Each character of the output may be printed in either uppercase or lowercase, i.e, `YES`, `yes`, `YEs`, and `yEs` will all be treated as equivalent.

### Constraints
- $1 \leq T \leq 10^5$
- $2 \leq N \leq 10^5$
- $1 \leq A_i \leq 10^9$
- The sum of $N$ across all test cases won't exceed $10^6$.
### Sample 1:
Input
Output

```
4
4
1 1 2 2
6
1 2 4 6 8 10
2
3 5
3
1 3 5
```

```
YES
NO
YES
NO
```

### Explanation:

 **Test case $1$:**  We have $A = [\underline{1}, 1, \underline{2}, 2]$. Let $S_1$ be the underlined elements and $S_2$ be the other ones. $sum(S_1) \times sum(S_2) = 3\times 3 = 9$.

 **Test case $2$:**  It can be proved that no partition of $A$ into $S_1, S_2$ satisfies the condition.

 **Test case $4$:**  Choose $S_1 = \{3\}, S_2 = \{5\}$.

 **Test case $4$:**  It can be proved that no partition of $A$ into $S_1, S_2$ satisfies the condition.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T18:21:08.634Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int odd = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();

                if (x % 2 != 0) {
                    odd++;
                }
            }

            if (odd >= 2 && odd % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/COUNTP)