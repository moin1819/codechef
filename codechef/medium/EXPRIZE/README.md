# EXPRIZE

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### The Prize Ladder

You are given an integer $N$.

Find the largest $K$ for which there exist integers $1 \leq a_1 < a_2 < \cdots < a_K$ such that

$a_1 + a_2 + \cdots + a_K = N \quad \text{and} \quad a_{i+1} - a_i \geq i \text{ for all } 1 \leq i < K.$

### Input Format
- The first line of input contains a single integer $T$, denoting the number of test cases.
- Each test case consists of a single line containing one integer $N$.
### Output Format

For each test case, output on a new line the largest $K$.

### Constraints
- $1 \leq T \leq 10^5$
- $1 \leq N \leq 10^{18}$
### Sample 1:
Input
Output

```
5
14
1
6
7
1000000000000000000

```

```
4
1
2
3
1817120
```

### Explanation:

Test case $1$: $14 = 1 + 2 + 4 + 7$ uses $K = 4$.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T16:25:35.053Z  

```py
t = int(input())

for _ in range(t):
    n = int(input())
    k = 0

    while (k + 1) * (k + 2) * (k + 3) // 6 <= n:
        k += 1

    print(k)
```

---

[View on CodeChef](https://www.codechef.com/problems/EXPRIZE)