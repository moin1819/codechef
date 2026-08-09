# LCPPAS162

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** c_cpp  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-09T04:23:02.969Z  

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

[View on CodeChef](https://www.codechef.com/problems/LCPPAS162)