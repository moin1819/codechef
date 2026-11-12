# COVID_19 - Rating 1077

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Covid and Theatre Tickets

Mr. Chef is the manager of the Code cinemas and after a long break, the theatres are now open to the public again. To compensate for the loss in revenue due to Covid-19, Mr. Chef wants to maximize the profits for every show from now on and at the same time follow the guidelines set the by government. The guidelines are:

- If two people are seated in the same row, there must be at least one empty seat between them.
- If two people are seated in different rows, there must be at least one completely empty row between them. That is, if there are people seated in rows $i$ and $j$ where $i \lt j$, there must be some row $k$ such that $i \lt k \lt j$ and nobody is seated in row $k$.

Given the information about the number of rows and the number of seats in each row, find the maximum number of tickets Mr. Chef can sell.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases. The description of $T$ test cases follows.
- Each test case consists of a single line of input containing two space-separated integers $N, M$ — the number of rows and the number of seats in each row, respectively.
### Output Format

For each test case, output a single line containing one integer – the maximum number of tickets Mr. Chef can sell.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq N,M\leq 100$
### Sample 1:
Input
Output

```
3
1 5
3 3
4 4
```

```
3
4
4
```

### Explanation:

 **Test Case 1:**  There is only one row with five seats. Mr. Chef can sell a maximum of 3 tickets for seat numbers 1, 3 and 5.

 **Test Case 2:**  There are three rows with three seats each. Mr. Chef can sell a maximum of 4 tickets, for seats at the start and end of row numbers 1 and 3.

 **Test Case 3:**  There are four rows with four seats each. Mr. Chef can sell a maximum of 4 tickets, for example by choosing the seats at the start and end of row numbers 1 and 4.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-12T13:26:59.801Z  

```java

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int ans = ((N + 1) / 2) * ((M + 1) / 2);

            System.out.println(ans);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/COVID_19)