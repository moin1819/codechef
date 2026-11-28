# EUREKA - Rating 1109

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### N Queens Puzzle Solved !

Chef, being a Chess fan, was thrilled after he read the following news:

Michael Simkin, a postdoctoral fellow at Harvard University’s Center of Mathematical Sciences and Applications proved that for a large value of $N$, there are approximately $(0.143 \cdot N)^N$ configurations in which $N$ queens can be placed on a $N \times N$ chessboard so that none attack each other.

Although the formula is valid for large $N$, Chef is interested in finding the value of function $f(N)$ = $(0.143 \cdot N)^N$ for a given small value of $N$. Since Chef is busy understanding the proof of the formula, please help him calculate this value.

Print the answer rounded to the nearest integer. That is, if the actual value of $f(N)$ is $x$,

- Print $\lfloor x\rfloor$ if $x - \lfloor x\rfloor \lt 0.5$
- Otherwise, print $\lfloor x\rfloor + 1$

where $\lfloor x\rfloor$ denotes the floor of $x$.

### Input Format
- The first line of input contains a single integer $T$, denoting the number of test cases. The description of $T$ test cases follows.
- Each test case consists of a single line of input containing one integer $N$.
### Output Format

For each test case, output in a single line the value of $f(N)$ rounded to the nearest integer.

### Constraints
- $1 \leq T \leq 12$
- $4 \leq N \leq 15$
### Subtasks

 **Subtask #1 (100 points):**  Original constraints

### Sample 1:
Input
Output

```
2
4
10
```

```
0
36

```

### Explanation:

 **Test case $1$:**  $f(N) = (0.143 \cdot 4)^4 = 0.107$, which when rounded to nearest integer gives $0$.

 **Test case $2$:**  $f(N) = (0.143 \cdot 10)^{10} = 35.7569$, which when rounded to nearest integer gives $36$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-28T07:54:33.360Z  

```java

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            double ans = Math.pow(0.143 * n, n);

            System.out.println(Math.round(ans));
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/EUREKA)