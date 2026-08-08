# FLOW001 - Rating 242

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Add Two Numbers

Your task is very simple: given two integers $A$ and $B$, write a program to add these two numbers and output the sum.

### Input Format
- The first line contains an integer $T$, the total number of test cases.
- Then follow $T$ lines, each line contains two integers, $A$ and $B$.
### Output Format

For each test case, add $A$ and $B$ and display the sum in a new line.

### Constraints
- $1 \leq T \leq 1000$
- $0 \leq A, B \leq 10000$
### Sample 1:
Input
Output

```
3
1 2
100 200
10 40
```

```
3
300
50
```

### Explanation:

 **Testcase 1:**  $1 + 2 = 3$. Hence the first output is $3$.

 **Testcase 2:**  $100 + 200 = 300$. Hence the second output is $300$.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-08T16:39:29.282Z  

```py
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

[View on CodeChef](https://www.codechef.com/problems/FLOW001)