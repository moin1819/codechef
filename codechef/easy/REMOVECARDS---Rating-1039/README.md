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
**Submitted:** 2026-09-04T18:38:13.338Z  

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        while (T-- > 0) {
            // Read N
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int N = Integer.parseInt(st.nextToken());
            
            // Frequency array for numbers 1 to 10
            int[] freq = new int[11];
            int maxFreq = 0;
            
            // Read array elements
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                freq[num]++;
                maxFreq = Math.max(maxFreq, freq[num]);
            }
            
            System.out.println(N - maxFreq);
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/REMOVECARDS)