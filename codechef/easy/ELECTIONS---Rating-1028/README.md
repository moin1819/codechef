# ELECTIONS - Rating 1028

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-24T12:27:13.411Z  

```py
import sys

def solve():
    input = sys.stdin.read
    data = input().split()
    if not data:
        return
    
    T = int(data[0])
    idx = 1
    
    for _ in range(T):
        A = int(data[idx])
        B = int(data[idx + 1])
        idx += 2
        
        limak_eaten = 0
        bob_eaten = 0
        turn = 1
        
        while True:
            # Limak's turn (odd numbers: 1, 3, 5, ...)
            if turn % 2 != 0:
                if limak_eaten + turn > A:
                    print("Bob")
                    break
                limak_eaten += turn
            # Bob's turn (even numbers: 2, 4, 6, ...)
            else:
                if bob_eaten + turn > B:
                    print("Limak")
                    break
                bob_eaten += turn
                
            turn += 1

if __name__ == "__main__":
    solve()
```

---

[View on CodeChef](https://www.codechef.com/problems/ELECTIONS)