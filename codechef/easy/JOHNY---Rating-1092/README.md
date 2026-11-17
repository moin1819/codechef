# JOHNY - Rating 1092

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-17T17:10:31.026Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] count = new int[n + 1];

            for (int i = 0; i < n; i++) {
                int p = sc.nextInt();
                count[p]++;
            }

            boolean possible = true;

            for (int i = 2; i <= n; i++) {
                if (count[i] % i != 0) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/JOHNY)