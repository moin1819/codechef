# THREEFR - Rating 1074

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Three Friends

There are three friends; let's call them A, B, C. They made the following statements:

- A: "I have $x$ Rupees more than B."
- B: "I have $y$ rupees more than C."
- C: "I have $z$ rupees more than A."

You do not know the exact values of $x, y, z$. Instead, you are given their absolute values, i.e. $X = |x|$, $Y = |y|$ and $Z = |z|$. Note that $x$, $y$, $z$ may be negative; "having $-r$ rupees more" is the same as "having $r$ rupees less".

Find out if there is some way to assign amounts of money to A, B, C such that all of their statements are true.

### Input
- The first line of the input contains a single integer $T$ denoting the number of test cases. The description of $T$ test cases follows.
- The first and only line of each test case contains three space-separated integers $X$, $Y$ and $Z$.
### Output

For each test case, print a single line containing the string `"yes"` if the presented scenario is possible or `"no"` otherwise (without quotes).

### Constraints
- $1 \le T \le 1,000$
- $1 \le X, Y, Z \le 1,000$
### Subtasks

 **Subtask #1 (30 points):** 

- $1 \le T \le 30$
- $1 \le X, Y, Z \le 3$

 **Subtask #2 (70 points):**  original constraints

### Sample 1:
Input
Output

```
2
1 2 1
1 1 1
```

```
yes
no
```

### Explanation:

 **Example 1** : One possible way to satisfy all conditions is: A has $10$ rupees, B has $9$ rupees and C has $11$ rupees. Therefore, we have $x = 1$, $y = -2$, $z = 1$.

 **Example 2** : There is no way for all conditions to be satisfied.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-10T13:22:25.416Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            if (X + Y == Z || X + Z == Y || Y + Z == X) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/THREEFR)