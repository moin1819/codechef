# LCPPAS109

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Print Squares

Write a program that utilizes a while loop to print the squares of numbers from 1 to $N$.

Check the sample input / output below further clarity.

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

**Language:** c_cpp  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-09T04:22:13.157Z  

```c_cpp
#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    
    int i = 1;
    while (i <= N) {
        cout << (i * i) << " ";
        i++;
    }
    
    return 0;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LCPPAS109)