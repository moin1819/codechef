# THREEFR - Rating 1069

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-08T17:35:35.787Z  

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

[View on CodeChef](https://www.codechef.com/problems/THREEFR)