# OPMIN - Rating 928

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-12T08:09:50.793Z  

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                if (x > largest) {
                    secondLargest = largest;
                    largest = x;
                } 
                else if (x > secondLargest && x != largest) {
                    secondLargest = x;
                }
            }

            System.out.println(largest + secondLargest);
        }

        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/OPMIN)