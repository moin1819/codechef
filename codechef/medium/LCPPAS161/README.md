# LCPPAS161

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** c_cpp  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-09T04:22:42.968Z  

```c_cpp
#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    
    long long factorial = 1;
    int i = 1;
    
    do {
        factorial *= i;
        i++;
    } while (i <= N);
    
    cout << factorial << endl;
    
    return 0;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LCPPAS161)