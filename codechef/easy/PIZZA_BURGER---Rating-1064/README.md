# PIZZA_BURGER - Rating 1064

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Hungry Ashish

It's dinner time. Ashish is very hungry and wants to eat something. He has $X$ rupees in his pocket. Since Ashish is very picky, he only likes to eat either `PIZZA` or `BURGER`. In addition, he prefers eating `PIZZA` over eating `BURGER`. The cost of a `PIZZA` is $Y$ rupees while the cost of a `BURGER` is $Z$ rupees.

Ashish can eat at most one thing. Find out what will Ashish eat for his dinner.

### Input Format
- The first line will contain $T$ - the number of test cases. Then the test cases follow.
- The first and only line of each test case contains three integers $X$, $Y$ and $Z$ - the money Ashish has, the cost of a PIZZA and the cost of a BURGER.
### Output Format

For each test case, output what Ashish will eat. (`PIZZA`, `BURGER` or `NOTHING`).

You may print each character of the string in uppercase or lowercase. (for example, the strings `Pizza`, `pIzZa` and `piZZa` will all be treated as identical).

### Constraints
- $1 \leq T \leq 100$
- $1 \leq X, Y, Z \leq 100$
### Sample 1:
Input
Output

```
3
50 40 60
40 55 39
30 42 37

```

```
PIZZA
BURGER
NOTHING

```

### Explanation:

 **Test case-1:**  Ashish has $50$ rupees while the cost of `PIZZA` is $40$. Therefore he can buy a `PIZZA` for his dinner.

 **Test case-2:**  Ashish has $40$ rupees. The cost of `PIZZA` is $55$ and the cost of `BURGER` is $39$. Therefore Ashish can not buy a `PIZZA` but can buy a `BURGER` for his dinner.

 **Test case-3:**  Ashish has $30$ rupees which are not sufficient to buy either `PIZZA` or `BURGER`. Thus he can not buy anything and remains hungry :(.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-02T10:43:13.930Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            if (X >= Y) {
                System.out.println("PIZZA");
            } 
            else if (X >= Z) {
                System.out.println("BURGER");
            } 
            else {
                System.out.println("NOTHING");
            }
        }
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/PIZZA_BURGER)