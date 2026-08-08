# PYPRACMCQ10

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Water Intake Check - MCQ

Recently, Chef visited his doctor. The doctor advised Chef to drink  **at least**  $2000$ ml of water each day.

Chef drank $X$ ml of water today. Select the options where Chef followed the doctor's advice.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-08T16:41:03.296Z  

```cpp
import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    T = int(input_data[0])
    idx = 1
    
    for _ in range(T):
        X = int(input_data[idx])
        Y = int(input_data[idx + 1])
        idx += 2
        
        # Check if the sum is strictly greater than 6
        if X + Y > 6:
            print("YES")
        else:
            print("NO")

if __name__ == '__main__':
    main()
```

---

[View on CodeChef](https://www.codechef.com/problems/PYPRACMCQ10)