# MAKEMONEY - Rating 1101

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Make Money

Chef has $N$ bags and an integer $X$. The $i^{th}$ bag contains $A_i$ coins such that $A_i \leq X$.

In one operation, Chef can:

- Pick any bag and increase its coins to $X$. Formally, if he choses the $i^{th}$ bag, he can set $A_i = X$.

Given that the cost of performing  **each**  operation is $C$ $(C \leq X)$ coins and Chef can perform the above operation any (possibly zero) number of times, determine the  **maximum**  value of

$(\sum_{i=1}^N A_i)$ $-$ (total cost paid by Chef),

if Chef performs the operations optimally.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line of each test case contains three space-separated integers $N$, $X$, and $C$ — the number of bags, maximum limit of coins on each bag and cost of each operation respectively. The next line contains $N$ space-separated integers $A_1, A_2, \dots, A_N$ - denoting the number of coins in each bag.
### Output Format

For each test case, output the maximum value of $\sum_{i=1}^N A_i$ $-$ total cost paid by Chef.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq N \leq 100$
- $1 \leq C \leq X \leq 100$
- $1 \leq A_i \leq X$
### Sample 1:
Input
Output

```
3
5 5 2
1 2 3 4 5
3 4 4
1 1 1
5 3 2
3 2 3 1 1

```

```
18
3
10

```

### Explanation:

 **Test case $1$:**  It is optimal for Chef to perform $2$ operations:

- Operation $1$: Choose $i = 1$ and set $A_1 = 5$ by using $2$ coins.
- Operation $2$: Choose $i = 2$ and set $A_2 = 5$ by using $2$ coins.

The final array is $A = [5, 5, 3, 4, 5]$ and the total cost is $2+2 = 4$. Thus, the value of $\sum_{i=1}^N A_i$ $-$ total cost is $(5+5+3+4+5) - 4 = 22-4 = 18$.

 **Test case $2$:**  It is optimal for Chef to perform $0$ operations. Thus, the final array remains $[1, 1, 1]$ and the cost is $0$. The value of $\sum_{i=1}^N A_i$ $-$ total cost is $(1+1+1) - 0 = 3$.

 **Test case $3$:**  It is optimal for Chef to perform $0$ operations. Thus, the final array remains $[3, 2, 3, 1, 1]$ and the cost is $0$. The value of $\sum_{i=1}^N A_i$ $-$ total cost is $(3+2+3+1+1) - 0 = 10$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T10:52:08.001Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            long x = scanner.nextLong();
            long c = scanner.nextLong();
            
            long totalSum = 0;
            
            for (int i = 0; i < n; i++) {
                long a = scanner.nextLong();
                // If replacing with X and paying C yields more coins, we do it.
                // Net coins from this bag if we modify = X - C
                if (x - c > a) {
                    totalSum += (x - c);
                } else {
                    totalSum += a;
                }
            }
            
            System.out.println(totalSum);
        }
        
        scanner.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/MAKEMONEY)