# PRACMCQ11

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Dice Sum Good Turn - MCQ

Chef and Chefina are playing with dice. In one turn, both of them roll their dice at once.

They consider a turn to be  *good*  if the  **sum**  of the numbers on their dice is greater than $6$.
Given that in a particular turn Chef and Chefina got $X$ and $Y$ on their respective dice, select the options which are good turns.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-10T08:41:58.724Z  

```cpp
#include <iostream>
using namespace std;

int main() {
    int T;
    cin >> T;

    while (T--) {
        int A, B;
        cin >> A >> B;
        cout << A + B << endl;
    }

    return 0;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/PRACMCQ11)