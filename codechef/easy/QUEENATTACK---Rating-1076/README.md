# QUEENATTACK - Rating 1076

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### The Attack of Queen

Chef has started developing interest in playing chess, and was learning how the Queen moves.

Chef has an empty $N \times N$ chessboard. He places a Queen at $(X, Y)$ and wonders - What are the number of cells that are under attack by the Queen?

 **Notes:** 

- The top-left cell is $(1, 1)$, the top-right cell is $(1, N)$, the bottom-left cell is $(N,1)$ and the bottom-right cell is $(N, N)$.
- The Queen can be moved any number of unoccupied cells in a straight line vertically, horizontally, or diagonally.
- The cell on which the Queen is present, is not said to be under attack by the Queen.
### Input Format
- The first line contains a single integer $T$ - the number of test cases. Then the test cases follow.
- The first and only line of each test case contains three integers $N$, $X$ and $Y$, as described in the problem statement.
### Output Format

For each test case, output in a single line, the total number of cells that are under attack by the Queen.

### Constraints
- $1 \leq T \leq 10^4$
- $1 \leq N \leq 10^6$
- $1 \leq X, Y \leq N$
### Sample 1:
Input
Output

```
5
1 1 1
3 2 2
3 2 1
2 2 2
150 62 41

```

```
0
8
6
3
527

```

### Explanation:

 **Test case 1:**  The only cell on the board is $(1,1)$. Since Queen stands on this cell, it is not under attack.

 **Test case 2:**  The Queen can attack the following cells: $\{(1, 1), (1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (3, 2), (3, 3)\}$.

 **Test case 3:**  The Queen can attack the following cells: $\{(1, 1), (1, 2), (2, 2), (2, 3), (3, 1), (3, 2)\}$.

 **Test case 4:**  The Queen can attack the following cells: $\{(1, 1), (1, 2), (2, 1)\}$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-11T11:50:44.438Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long ans = (n - 1) + (n - 1);

            ans += Math.min(x - 1, y - 1);
            ans += Math.min(x - 1, n - y);
            ans += Math.min(n - x, y - 1);
            ans += Math.min(n - x, n - y);

            System.out.println(ans);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/QUEENATTACK)