# BM06 - Rating 258

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Practice problem - Fitness

Another practice problem for you.

Chef wants to become fit for which he decided to  **walk to**  the office and  **return**  home by walking.
It is known that Chef's office is $X$ km away from his home.
If his office is open on $5$ days in a week, find the number of kilometres Chef travels through office trips in a week.

 **Hint** 

- Return trips imply that $2$*$X$ distance is travelled each day
### Input Format
- First line will contain $T$, number of test cases. Then the test cases follow.
- Each test case contains of a single line consisting of single integer $X$.
### Output Format

For each test case, output the number of kilometers Chef travels through office trips in a week.

### Sample 1:
Input
Output

```
2
1
7

```

```
10
70

```

### Explanation:

 **Test case $1$:**  The office is $1$ km away. Thus, to go to the office and come back home, Chef has to walk $2$ kms in a day. In a week with $5$ working days, Chef has to travel $2\cdot 5 = 10$ kms in total.

 **Test case $2$:**  The office is $7$ kms away. Thus, to go to the office and come back home, Chef has to walk $14$ kms in a day. In a week with $5$ working days, Chef has to travel $14\cdot 5 = 70$ kms in total.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-02T15:28:39.151Z  

```py
T = int(input())

for _ in range(T):
    X = int(input())
    print(10 * X)
```

---

[View on CodeChef](https://www.codechef.com/problems/BM06)