# LAPTOPREC - Rating 1104

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Laptop Recommendation

Chef wants to buy a new laptop. However, he is confused about which laptop to buy out of $10$ different laptops. He asks his $N$ friends for their recommendation. The $i^{th}$ friend recommends the Chef to buy the ${A_i}^{th}$ laptop $(1 \le A_i \le 10)$.

Chef will buy the laptop which is recommended by  **maximum**  number of friends. Determine which laptop Chef buys.
Print `CONFUSED` if there are multiple laptops having maximum number of recommendations.

### Input Format
- The first line contains a single integer $T$ - the number of test cases. Then the test cases follow.
- The first line of each test case contains an integer $N$ - the number of Chef's friends.
- The second line of each test case contains $N$ space-separated integers $A_1, A_2, \dots, A_N$ where $A_i$ denotes the recommendation of the $i^{th}$ friend.
### Output Format

For each test case, output in a single line, the laptop which has the  **maximum**  number of recommendations. Print `CONFUSED` if there are multiple laptops having maximum number of recommendations.

You may print each character of `CONFUSED` in uppercase or lowercase (for example, `Confused`, `coNFused`, `CONFused` will be considered identical).

### Constraints
- $1 \leq T \leq 200$
- $1 \leq N \leq 1000$
- $1 \le A_i \le 10$
### Sample 1:
Input
Output

```
4
5
4 4 4 2 1
7
1 2 3 4 5 6 6
6
2 2 3 3 10 8
4
7 7 8 8

```

```
4
6
CONFUSED
CONFUSED

```

### Explanation:

 **Test case 1:**  Laptop $4$ has the maximum number of recommendations. Therefore, Chef will buy the $4^{th}$ laptop.

 **Test case 2:**  Laptop $6$ has the maximum number of recommendations. Therefore, Chef will buy the $6^{th}$ laptop.

 **Test case 3:**  Laptops $2$, $3$ have the maximum number of recommendations. Therefore, Chef will still be `CONFUSED`.

 **Test case 4:**  Laptops $7$, $8$ have the maximum number of recommendations. Therefore, Chef will still be `CONFUSED`.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-26T09:05:01.148Z  

```java

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int[] count = new int[11];

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                count[x]++;
            }

            int max = 0;
            int laptop = 0;
            int frequency = 0;

            for (int i = 1; i <= 10; i++) {
                if (count[i] > max) {
                    max = count[i];
                    laptop = i;
                    frequency = 1;
                } else if (count[i] == max) {
                    frequency++;
                }
            }

            if (frequency == 1) {
                System.out.println(laptop);
            } else {
                System.out.println("CONFUSED");
            }
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/LAPTOPREC)