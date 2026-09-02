# GOODSUBSETEZ

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Good Subset (Easy)

A set $S$ is said to be good if the following condition holds:

- for all $x, y \in S$, $x \oplus y < x$ $\&$ $y$, where $\oplus$ represents the bitwise XOR operator, and $\&$ represents the Bitwise AND operator.

Define $f(S)$ as the size of the largest good subset of $S$.

You are given a set $S$ of $N$ elements. Find $f(S)$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line contains a single integer $N$. The second line contains $N$ integers - $S_1, S_2, \ldots, S_N$, the elements of the set.
### Output Format

For each test case, output on a new line the value $f(S)$

### Constraints
- $1 \le T \le 10^4$
- $1 \le N \le 2 \cdot 10^5$
- $1 \le S_i \le 10^9$
- $S_i \ne S_j$ for all $i \ne j$
- The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$
### Sample 1:
Input
Output

```
2
3
1 2 3
5
8 20 4 100 1

```

```
2
1
```

### Explanation:

 **Test Case 1:**  $\{2, 3\}$ is a valid good subset (and the only valid one of size $2$).

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-02T15:37:14.442Z  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int[] count = new int[31];

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                // Find position of highest set bit
                int highestBit = 31 - Integer.numberOfLeadingZeros(x);

                count[highestBit]++;
            }

            int answer = 0;

            for (int i = 0; i < 31; i++) {
                answer = Math.max(answer, count[i]);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/GOODSUBSETEZ)