# PRACMCQ10

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Water Consumption Requirement - MCQ

Recently, Chef visited his doctor. The doctor advised Chef to drink  **at least**  $2000$ ml of water each day.

Chef drank $X$ ml of water today. Select the options where Chef followed the doctor's advice.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-11T08:42:02.122Z  

```cpp
#include <iostream>
using namespace std;

int main() {
    int t;
    cin >> t;
    while(t--) {
        int x, y;
        cin >> x >> y;
        if (x + y > 6) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    return 0;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/PRACMCQ10)