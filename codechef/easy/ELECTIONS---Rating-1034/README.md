# ELECTIONS - Rating 1034

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Elections in Chefland

There are $101$ citizens in Chefland. It is election time in Chefland and $3$ parties, $A, B$, and $C$ are contesting the elections. Party $A$ receives $X_A$ votes, party $B$ receives $X_B$ votes, and party $C$ receives $X_C$ votes.

The constitution of Chefland requires a particular party to receive a clear majority to form the government. A party is said to have a clear majority if it receives  **strictly**  greater than $50$ votes.

If any party has a clear majority, print the winning party (`A`, `B` or `C`). Otherwise, print `NOTA`.

### Input Format
- The first line of input contains a single integer $T$, denoting the number of test cases. The description of $T$ test cases follows.
- The first and only line of each test case contains $3$ space-separated integers — $X_A$, $X_B$, and $X_C$.
### Output Format

For each test case, if any party has a clear majority, print the winning party (`A`, `B` or `C`). Otherwise, print `NOTA`.

You can print each letter of the string in any case (upper or lower) (for instance, strings `Nota`, `nOtA` and `notA` will be considered identical).

### Constraints
- $1 \leq T \leq 500$
- $0 \leq X_A, X_B, X_C \leq 101$
- $X_A + X_B + X_C = 101$
### Sample 1:
Input
Output

```
3
80 19 2
20 55 26
50 1 50

```

```
A
B
NOTA

```

### Explanation:

 **Test Case $1$:**  Party $A$ has received $80$ votes, which is strictly greater than $50$.

 **Test Case $2$:**  Party $B$ has received $55$ votes, which is strictly greater than $50$.

 **Test Case $3$:**  None of the parties have received strictly more than $50$ votes.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-02T15:30:06.864Z  

```py
T = int(input())

for _ in range(T):
    XA, XB, XC = map(int, input().split())

    if XA > 50:
        print("A")
    elif XB > 50:
        print("B")
    elif XC > 50:
        print("C")
    else:
        print("NOTA")
```

---

[View on CodeChef](https://www.codechef.com/problems/ELECTIONS)