# AIRLINE - Rating 1042

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Airline Restrictions

Chef has $3$ bags that she wants to take on a flight. They weigh $A$, $B$, and $C$ kgs respectively. She wants to check-in exactly two of these bags and carry the remaining one bag with her.

The airline restrictions says that the total sum of the weights of the bags that are checked-in cannot exceed $D$ kgs and the weight of the bag which is carried cannot exceed $E$ kgs. Find if Chef can take all the three bags on the flight.

### Input Format
- The first line of the input contains a single integer $T$ denoting the number of test cases. The description of $T$ test cases follows.
- Each testcase contains a single line of input, five space separated integers $A, B, C, D, E$.
### Output Format

For each testcase, output in a single line answer `"YES"` if Chef can take all the three bags with her or `"NO"` if she cannot.

You may print each character of the string in uppercase or lowercase (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).

### Constraints
- $1 \leq T \leq 36000$
- $1 \leq A, B, C \leq 10$
- $15 \leq D \leq 20$
- $5 \leq E \leq 10$
### Subtasks

 **Subtask #1 (100 points):**  original constraints

### Sample 1:
Input
Output

```
3
1 1 1 15 5
8 7 6 15 5
8 5 7 15 6
```

```
YES
NO
YES
```

### Explanation:

 **Test case $1$:**  Chef can check-in the first and second bag (since $1 + 1 = 2 \le 15$) and carry the third bag with her (since $1 \le 5$).

 **Test case $2$:**  None of the three bags can be carried in hand without violating the airport restrictions.

 **Test case $3$:**  Chef can check-in the first and the third bag (since $8 + 7 \le 15$) and carry the second bag with her (since $5 \le 6$).

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T09:47:26.651Z  

```java
import java.util.Scanner;

public class Main {
    public static void solve(Scanner sc) {
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();

        // Check all 3 possible combinations for (checked-in bags, carry-on bag)
        if ((A + B <= D && C <= E) || 
            (A + C <= D && B <= E) || 
            (B + C <= D && A <= E)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/AIRLINE)