# ODDPAIRS - Rating 1044

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Odd Pairs

Given an integer $N$, determine the number of pairs $(A, B)$ such that:

- $1 \leq A, B \leq N$;
- $A + B$ is odd.
### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of a single integer $N$.
### Output Format

For each test case, output the number of required pairs.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq N \leq 10^9$
### Sample 1:
Input
Output

```
5
1
2
3
100
199

```

```
0
2
4
5000
19800

```

### Explanation:

 **Test case $1$:**  There are no pairs satisfying the given conditions.

 **Test case $2$:**  The pairs satisfying both conditions are: $(1, 2)$ and $(2, 1)$.

 **Test case $3$:**  The pairs satisfying both conditions are: $(1, 2), (2, 1), (2, 3),$ and $(3, 2)$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T07:54:59.802Z  

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();

            long odd = (N + 1) / 2;
            long even = N / 2;

            long answer = 2 * odd * even;

            System.out.println(answer);
        }

        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/ODDPAIRS)