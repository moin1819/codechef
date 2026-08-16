# TITLECASE

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-16T06:20:13.855Z  

```java
public static String findLargestOddSubstring(String num) {
    if (num == null) {
        return "-1";
    }

    for (int i = num.length() - 1; i >= 0; i--) {
        int digit = num.charAt(i) - '0';

        if (digit % 2 != 0) {
            return num.substring(0, i + 1); // Returns the result instead of printing
        }
    }

    return "-1"; // Returns fallback instead of printing
}
```

---

[View on CodeChef](https://www.codechef.com/problems/TITLECASE)