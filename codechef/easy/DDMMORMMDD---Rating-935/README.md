# DDMMORMMDD - Rating 935

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** c_cpp  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-15T11:41:55.159Z  

```c_cpp
#include <stdio.h>

void solve() {
    long long x;
    char s[15];
    if (scanf("%lld %s", &x, s) != 2) return;

    int carlsen = 0, chef = 0;
    for (int i = 0; i < 14; i++) {
        if (s[i] == 'C') {
            carlsen += 2;
        } else if (s[i] == 'N') {
            chef += 2;
        } else if (s[i] == 'D') {
            carlsen += 1;
            chef += 1;
        }
    }

    if (carlsen > chef) {
        printf("%lld\n", 60 * x);
    } else if (carlsen == chef) {
        printf("%lld\n", 55 * x);
    } else {
        printf("%lld\n", 40 * x);
    }
}

int main() {
    int t;
    if (scanf("%d", &t) == 1) {
        while (t--) {
            solve();
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/DDMMORMMDD)