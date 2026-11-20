# CHEFSTR1 - Rating 1094

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Chef and Strings

Having already mastered cooking, Chef has now decided to learn how to play the guitar. Often while trying to play a song, Chef has to skip several strings to reach the string he has to pluck. Eg. he may have to pluck the $1^{st}$ string and then the $6^{th}$ string. This is easy in guitars with only $6$ strings; However, Chef is playing a guitar with $10^6$ strings. In order to simplify his task, Chef wants you to write a program that will tell him the total number of strings he has to skip while playing his favourite song.

This is how guitar strings are numbered (In ascending order from right to left). Eg. to switch from string $1$ to $6$, Chef would have to skip $4$ strings $(2, 3, 4, 5)$.

### Input:
- First line will contain $T$, number of testcases. Then the testcases follow.
- The first line of each test case contains $N$, the number of times Chef has to pluck a string
- The second line of each test case contains $N$ space separated integers - $S_1$, $S_2$,..., $S_N$, where $S_i$ is the number of the $i^{th}$ string Chef has to pluck.
### Output:

For each testcase, output the total number of strings Chef has to skip over while playing his favourite song.

### Constraints
- $1 \leq T \leq 10$
- $2 \leq N \leq 10^5$
- $1 \leq S_i \leq 10^6$
- For each valid $i$, $S_i \neq S_{i+1}$
### Subtasks
- 30 points : for each valid $i$, $S_i < S_{i+1}$
- 70 points : No additional constraints
### Sample 1:
Input
Output

```
2
6
1 6 11 6 10 11
4
1 3 5 7
```

```
15
3
```

### Explanation:

 **Test Case**  $1$

- Chef skips $4$ strings $(2, 3, 4, 5)$ to move from $1$ to $6$
- Chef skips $4$ strings $(7, 8, 9, 10)$ to move from $6$ to $11$
- Chef skips $4$ strings $(10, 9, 8, 7)$ to move from $11$ to $6$
- Chef skips $3$ strings $(7, 8, 9)$ to move from $6$ to $10$
- Chef skips $0$ strings to move from $10$ to $11$

Therefore, the answer is $4 + 4 + 4 + 3 + 0 = 15$

 **Test Case**  $2$

- Chef skips $1$ string to move from $1$ to $3$
- Chef skips $1$ string to move from $3$ to $5$
- Chef skips $1$ string to move from $5$ to $7$

Therefore, the answer is $1 + 1 + 1 = 3$

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-20T13:24:51.822Z  

```java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int prev = sc.nextInt();
            int ans = 0;

            for (int i = 1; i < n; i++) {
                int curr = sc.nextInt();

                ans += Math.abs(curr - prev) - 1;

                prev = curr;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/CHEFSTR1)