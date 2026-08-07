# LPYAS109

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Print Squares

Write a program that utilizes a while loop to print the squares of numbers from 1 to $N$.

Check the sample input / output below further clarity

### Sample 1:
Input
Output

```
5
```

```
1 4 9 16 25
```

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-07T13:53:48.579Z  

```py
def print_squares():
    N = int(input())
    i = 1
    squares = []
    while i <= N:
        squares.append(str(i * i))
        i += 1
    print(" ".join(squares))
if __name__ == "__main__":
    print_squares()
```

---

[View on CodeChef](https://www.codechef.com/problems/LPYAS109)