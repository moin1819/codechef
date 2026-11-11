# COVID_19 - Rating 1076

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-11T11:50:45.970Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long ans = (n - 1) + (n - 1);

            ans += Math.min(x - 1, y - 1);
            ans += Math.min(x - 1, n - y);
            ans += Math.min(n - x, y - 1);
            ans += Math.min(n - x, n - y);

            System.out.println(ans);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/COVID_19)