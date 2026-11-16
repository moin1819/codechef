# GRPASSN - Rating 1092

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Group Assignment

Chef is hosting a party at his house and $N$ people are invited to it. Everyone has arrived and they are eager to make a group and chit-chat.

The $i^{th}$ person prefers to be in a group of  **exactly**  $P_i$ people (including himself). A person who is not in a group of preferred size gets upset. Find whether Chef would be able to assign every person to a group such that everyone remains happy.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line of each test case contains an integer $N$ — the number of people at the party. The next line contains the array $P$ — where $P_{i}$ denotes the preferred group size for $i^{th}$ person.
### Output Format

For each test case, output `YES`, if Chef can assign every person to a group such that everyone remains happy. Otherwise output `NO`.

The output is case-insensitive, meaning that outputs such as `yES`, `YeS`, `YES` and `yes` mean the same.

### Constraints
- $1 \leq T \leq 1000$
- $2 \leq N \leq 10^{5}$
- $2 \leq P_{i} \leq N$
- Sum of $N$ over all test cases does not exceed $10^{5}$.
### Sample 1:
Input
Output

```
4
5
2 3 2 3 3
5
5 5 5 5 5
5
3 2 2 3 2
4
4 4 4 3

```

```
YES
YES
NO
NO

```

### Explanation:

 **Test case $1$:** 

- Person $1$ and $3$ can make a group (As both want to be in a group of $2$).
- Person $2$, $4$ and $5$ can make a group (As they all want to be in a group of $3$).

So, there is a possible arrangement that Chef can make so that all of them are happy.

 **Test case $2$** :

- All of the $5$ people can make a group (As all want to be in a group of $5$).

So, there is a possible arrangement that Chef can make so that all of them are happy.

 **Test case $3$:**  It can be shown that there is no possible arrangement that Chef can make so that all of them are happy.

 **Test case $4$:**  It can be shown that there is no possible arrangement that Chef can make so that all of them are happy.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-16T05:54:16.085Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] freq = new int[n + 1];

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                freq[x]++;
            }

            boolean possible = true;

            for (int i = 2; i <= n; i++) {
                if (freq[i] % i != 0) {
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

[View on CodeChef](https://www.codechef.com/problems/GRPASSN)