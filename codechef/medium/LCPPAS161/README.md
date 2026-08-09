# LCPPAS161

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Find the number of digits

Given an integer  **N**, Calculate and print the number of digits present in  **N**.

### Constraints
- $1 \leq N \leq 10^8$
### Sample 1:
Input
Output

```
1543
```

```
4
```

## Solution

**Language:** c_cpp  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-09T04:23:01.074Z  

```c_cpp
#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    
    int count = 0;
    int temp = N;
    
    while (temp > 0) {
        count++;
        temp /= 10; // Remove the last digit
    }
    
    cout << count << endl;
    
    return 0;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LCPPAS161)