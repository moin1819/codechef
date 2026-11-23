# MSNSADM1 - Rating 1102

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Football

A football competition has just finished. The players have been given points for scoring goals and points for committing fouls. Now, it is up to Alex to find the best player in the tournament. As a programmer, your job is to help Alex by telling him the highest number of points achieved by some player.

You are given two sequences $A_1, A_2, \ldots, A_N$ and $B_1, B_2, \ldots, B_N$. For each valid $i$, player $i$ scored $A_i$ goals and committed $B_i$ fouls. For each goal, the player that scored it gets $20$ points, and for each foul, $10$ points are deducted from the player that committed it. However, if the resulting number of points of some player is negative, this player will be considered to have $0$ points instead.

You need to calculate the total number of points gained by each player and tell Alex the maximum of these values.

### Input
- The first line of the input contains a single integer $T$ denoting the number of test cases. The description of $T$ test cases follows.
- The first line of each test case contains a single integer $N$.
- The second line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$.
- The third line contains $N$ space-separated integers $B_1, B_2, \ldots, B_N$.
### Output

For each test case, print a single line containing one integer ― the maximum number of points.

### Constraints
- $1 \le T \le 100$
- $1 \le N \le 150$
- $0 \le A_i \le 50$ for each valid $i$
- $0 \le B_i \le 50$ for each valid $i$
### Subtasks

 **Subtask #1 (30 points):**  $1 \le N \le 2$

 **Subtask #2 (70 points):**  original constraints

### Sample 1:
Input
Output

```
2
3
40 30 50
2 4 20
1
0
10
```

```
800
0
```

### Explanation:

 **Example case 1:**  The first player gets $800$ points for scoring goals and has $20$ points deducted for fouls. Likewise, the second player gets $560$ points and the third player gets $800$ points. The third player is the one with the maximum number of points.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-23T08:30:54.149Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                int score = (a[i] * 20) - (b[i] * 10);

                if (score < 0) {
                    score = 0;
                }

                max = Math.max(max, score);
            }

            System.out.println(max);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/MSNSADM1)