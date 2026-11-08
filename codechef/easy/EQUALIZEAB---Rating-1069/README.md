# EQUALIZEAB - Rating 1069

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Equalize AB

You are given two numbers $A$ and $B$ along with an integer $X$. In one operation you can do one of the following:

- Set $A = A + X$ and $B = B - X$
- Set $A = A - X$ and $B = B + X$

Determine if you can make $A$ and $B$ equal after applying the operation any number of times (possibly zero).

### Input Format
- The first line contains a single integer $T$ — the number of test cases. Then the test cases follow.
- The first and only line of each test case contains two space-separated integers $A, B$ and $X$ — the parameters mentioned in the statement.
### Output Format

For each test case, output `YES` if you can make $A$ and $B$ equal after applying the operation any number of times (possibly zero). Otherwise, output `NO`.

You can output each letter in any case i.e. `YES`, `yes`, `yEs` are all considered the same.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq A, B, X \leq 10^9$
### Sample 1:
Input
Output

```
4
5 7 1
3 4 2
4 4 6
2 5 3

```

```
YES
NO
YES
NO

```

### Explanation:

 **Test Case 1:**  The initial values of $(A, B)$ is $(5, 7)$. We can perform the following operation: $(5,7) \xrightarrow{A = A + X, B = B - X} (6,6)$.

 **Test Case 2:**  It can be proven that we can not make $A$ equal to $B$ using the given operations.

 **Test Case 3:**  $A$ and $B$ are already equal.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-08T17:35:33.810Z  

```py
def solve():
    A, B, X = map(int, input().split())
    diff = abs(A - B)
    
    if diff % (2 * X) == 0:
        print("YES")
    else:
        print("NO")

t = int(input())
for _ in range(t):
    solve()
```

---

[View on CodeChef](https://www.codechef.com/problems/EQUALIZEAB)