# PYPRACMCQ11

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Good Turns - MCQ

Chef and Chefina are playing with dice. In one turn, both of them roll their dice at once.

They consider a turn to be  *good*  if the  **sum**  of the numbers on their dice is greater than $6$.
Given that in a particular turn Chef and Chefina got $X$ and $Y$ on their respective dice, select the options which are good turns.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-08T16:39:53.768Z  

```cpp
import sys

def main():
    # Read all inputs from standard input
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    # First token is the number of test cases T
    T = int(input_data[0])
    
    idx = 1
    for _ in range(T):
        A = int(input_data[idx])
        B = int(input_data[idx + 1])
        print(A + B)
        idx += 2

if __name__ == '__main__':
    main()
```

---

[View on CodeChef](https://www.codechef.com/problems/PYPRACMCQ11)