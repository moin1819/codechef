# FARAWAY - Rating 1090

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Far Away

Chef has an array $A$ of size $N$ and an integer $M$, such that $1 \leq A_i \leq M$ for every $1 \leq i \leq N$.

The  *distance*  of an array $B$ from array $A$ is defined as:

$$ d(A, B) = \sum_{i=1}^N |A_i - B_i| $$

Chef wants an array $B$ of size $N$, such that $1 \le B_i \le M$ and the value $d(A, B)$ is as large as possible, i.e, the distance of $B$ from $A$ is  **maximum**.

Find the  **maximum**  distance for any valid array $B$.

Note: $|X|$ denotes the absolute value of an integer $X$. For example, $|-4| = 4$ and $|7| = 7$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains two space-separated integers $N$ and $M$ — the length of array $A$ and the limit on the elements of $A$ and $B$. The second line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$.
### Output Format

For each test case, output on a new line the  **maximum**  distance of an array from $A$.

### Constraints
- $1 \leq T \leq 10^5$
- $1 \leq N \leq 2\cdot 10^5$
- $1 \leq M \leq 10^9$
- $1 \leq A_i \leq M$
- The sum of $N$ over all test cases won't exceed $3\cdot 10^5$.
### Sample 1:
Input
Output

```
4
2 6
3 5
4 1
1 1 1 1
5 7
2 3 4 5 6
7 24
23 7 6 16 12 4 24

```

```
7
0
21
127

```

### Explanation:

 **Test case $1$:**  The array having maximum distance from $A$ is $B = [6, 1]$. Thus the distance is $|3-6| + |5-1| = 3+4=7$.

 **Test case $2$:**  The only array possible is $B = [1,1,1,1]$. The distance of this array from $A$ is $0$.

 **Test case $3$:**  One of the possible arrays having maximum distance from $A$ is $B = [7,7,1,1,1]$. Thus the distance is $|2-7| + |3-7| + |4-1| + |5-1| + |6-1| = 5+4+3+4+5=21$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-15T16:19:01.860Z  

```java

import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            long M = sc.nextLong();

            long ans = 0;

            for (int i = 0; i < N; i++) {
                long x = sc.nextLong();

                ans += Math.max(x - 1, M - x);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/FARAWAY)