# AORB - Rating 728

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### A or B

There are two problems in a contest.

- Problem A is worth $500$ points at the start of the contest.
- Problem B is worth $1000$ points at the start of the contest.

Once the contest starts, after each minute:

- Maximum points of Problem A reduce by $2$ points.
- Maximum points of Problem B reduce by $4$ points.

It is known that Chef requires $X$ minutes to solve Problem `A` correctly and $Y$ minutes to solve Problem `B` correctly.

Find the  **maximum**  number of points Chef can score if he optimally decides the order of attempting both the problems.

### Input Format
- First line will contain $T$, number of test cases. Then the test cases follow.
- Each test case contains of a single line of input, two integers $X$ and $Y$ - the time required to solve problems $A$ and $B$ in minutes respectively.
### Output Format

For each test case, output in a single line, the  **maximum**  number of points Chef can score if he optimally decides the order of attempting both the problems.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq X, Y \leq 100$
### Sample 1:
Input
Output

```
4
10 20
8 40
15 15
20 10

```

```
1360
1292
1380
1400

```

### Explanation:

 **Test Case $1$:**  If Chef attempts in the order $A \rightarrow B$ then he submits Problem `A` after $10$ minutes and Problem `B` after $30$ minutes.
Thus, he gets $500 - 10 \cdot 2 = 480$ points for problem `A` and $1000 - 30 \cdot 4 = 880$ points for problem `B`. Thus, total $480+880=1360$ points for both the problems.

If Chef attempts in the order $B \rightarrow A$ then he submits Problem `B` after $20$ minutes and Problem `A` after $30$ minutes.
Thus, he gets $1000 - 20 \cdot 4 = 920$ points for Problem `B` and $500 - 30 \cdot 2 = 440$ points for Problem `A`. Thus total $920+440=1360$ points for both the problems.

So, in both cases Chef gets $1360$ points in total.

 **Test Case $2$:**  If Chef attempts in the order $A \rightarrow B$ then he submits Problem `A` after $8$ minutes and Problem `B` after $48$ minutes.
Thus, he gets $500 - 8 \cdot 2 = 484$ points for problem `A` and $1000 - 48 \cdot 4 = 808$ points for problem `B`. Thus, total $484+808=1292$ points for both the problems.

If Chef attempts in the order $B \rightarrow A$ then he submits Problem `B` after $40$ minutes and Problem `A` after $48$ minutes.
Thus, he gets $1000 - 40 \cdot 4 = 840$ points for Problem `B` and $500 - 48 \cdot 2 = 404$ points for Problem `A`. Thus total $840+404=1244$ points for both the problems.

So, Chef will attempt in the order $A \rightarrow B$ and thus obtain $1292$ points.

 **Test Case $3$:**  If Chef attempts in the order $A \rightarrow B$ then he submits Problem `A` after $15$ minutes and Problem `B` after $30$ minutes.
Thus, he gets $500 - 15 \cdot 2 = 470$ points for problem `A` and $1000 - 30 \cdot 4 = 880$ points for problem `B`. Thus, total $470+880=1350$ points for both the problems.

If Chef attempts in the order $B \rightarrow A$ then he submits Problem `B` after $15$ minutes and Problem `A` after $30$ minutes.
Thus, he gets $1000 - 15 \cdot 4 = 940$ points for Problem `B` and $500 - 30 \cdot 2 = 440$ points for Problem `A`. Thus total $940+440=1380$ points for both the problems.

So, Chef will attempt in the order $B \rightarrow A$ and thus obtain $1380$ points.

 **Test Case $4$:**  If Chef attempts in the order $A \rightarrow B$ then he submits Problem `A` after $20$ minutes and Problem `B` after $30$ minutes.
Thus, he gets $500 - 20 \cdot 2 = 460$ points for problem `A` and $1000 - 30 \cdot 4 = 880$ points for problem `B`. Thus, total $460+880=1340$ points for both the problems.

If Chef attempts in the order $B \rightarrow A$ then he submits Problem `B` after $10$ minutes and Problem `A` after $30$ minutes.
Thus, he gets $1000 - 10 \cdot 4 = 960$ points for Problem `B` and $500 - 30 \cdot 2 = 440$ points for Problem `A`. Thus total $960+440=1400$ points for both the problems.

So, Chef will attempt in the order $B \rightarrow A$ and thus obtain $1400$ points.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-07T13:23:14.953Z  

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        // Helper method to parse input quickly
        if (!st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return;
            st = new StringTokenizer(line);
        }

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            // Order A -> B
            int order1 = (500 - 2 * X) + (1000 - 4 * (X + Y));

            // Order B -> A
            int order2 = (1000 - 4 * Y) + (500 - 2 * (X + Y));

            sb.append(Math.max(order1, order2)).append("\n");
        }

        System.out.print(sb);
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/AORB)