# REMOVECARDS - Rating 1039

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Card Removal

You have $N$ cards placed in front of you on the table. The $i^{th}$ card has the number $A_i$ written on it.

In one move, you can  **remove**  any one card from the remaining cards on the table.

Find the  **minimum**  number of moves required so that all the cards remaining on the table have the  **same**  number written on them.

### Input Format
- The first line contains a single integer $T$ — the number of test cases. Then the test cases follow.
- The first line of each test case contains an integer $N$ — the number of cards on the table.
- The second line of each test case contains $N$ space-separated integers $A_1, A_2, \dots, A_N$ where $A_i$ is the number written on the $i^{th}$ card.
### Output Format

For each test case, output the  **minimum**  number of moves required so that all the cards remaining on the table have the same number written on them.

### Constraints
- $1 \leq T \leq 100$
- $1 \le N \le 100$
- $1 \le A_i \le 10$
### Sample 1:
Input
Output

```
3
5
1 1 2 2 3
4
8 8 8 8
6
5 6 7 8 9 10

```

```
3
0
5

```

### Explanation:

 **Test case $1$:**  The minimum number of moves required such that all remaining cards have same values is $3$:

- Move $1$: Remove a card with number $1$. Remaining cards are $[1, 2, 2, 3]$.
- Move $2$: Remove a card with number $1$. Remaining cards are $[2, 2, 3]$.
- Move $3$: Remove a card with number $3$. Remaining cards are $[2, 2]$.

 **Test case $2$:**  All cards have the same number initially. Thus, no moves are required.

 **Test case $3$:**  The minimum number of moves required such that all remaining cards have same values is $5$:

- Move $1$: Remove a card with number $5$. Remaining cards are $[6, 7, 8, 9, 10]$.
- Move $2$: Remove a card with number $6$. Remaining cards are $[7, 8, 9, 10]$.
- Move $3$: Remove a card with number $7$. Remaining cards are $[8, 9, 10]$.
- Move $4$: Remove a card with number $8$. Remaining cards are $[9, 10]$.
- Move $5$: Remove a card with number $9$. Remaining cards are $[10]$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-15T04:17:23.179Z  

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] freq = new int[11];
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                freq[x]++;
        }
            int maxFreq = 0;
            for (int i = 1; i <= 10; i++) {
                maxFreq = Math.max(maxFreq, freq[i]);
    }
            System.out.println(N - maxFreq); 
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/REMOVECARDS)