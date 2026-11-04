# MASKPOL - Rating 1064

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Mask Policy

A city has been infected by a contagious virus.

In a survey, it was found that $A$ out of the $N$ people living in the city are currently infected. It has been observed that the only way for a person to get infected is if he comes in contact with an already infected person, and both of them are NOT wearing a mask.

The mayor of the city wants to make a new Mask Policy and find out the minimum number of people that will be required to wear a mask to avoid the further spread of the virus. Help the mayor in finding this number.

Note: The only aim of the mayor is to stop virus spread, not to mask every infected person.

### Input Format
- The first line contains $T$ - number of test cases. Then the test cases follow.
- The first and only line of each test case contains two integers $N$ and $A$ - the total number of people living in the city and the number of people already affected by the virus respectively.
### Output Format

For each test case, output the minimum number of people that will be required to wear a mask so as to curb the virus spread.

### Constraints
- $1 \leq T \leq 10^5$
- $2 \leq N \leq 400$
- $1 \leq A \lt N$
### Sample 1:
Input
Output

```
3
2 1
3 2
3 1
```

```
1
1
1
```

### Explanation:

 **Test Case #1** : There is $1$ infected person and $1$ uninfected person. We can ask any of them to wear a mask, and no more infections will occur. Hence the answer is $1$.

 **Test Case #2** : There are $2$ infected people and $1$ uninfected person. We can ask the uninfected person to wear a mask, and no more infections will occur. Hence the answer is $1$.

 **Test Case #3** : There is $1$ infected person and $2$ uninfected people. We can ask the single infected person to wear a mask, and no more infections will occur. Hence the answer is $1$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T04:56:51.496Z  

```java
import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();

            System.out.println(Math.min(a, n - a));
        }

        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/MASKPOL)