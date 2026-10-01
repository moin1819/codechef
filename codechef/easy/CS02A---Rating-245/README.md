# CS02A - Rating 245

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Practice problem - Age Limit

Best way to learn - practice and solve problems based on the concept!!!

### Task

Chef wants to appear in a competitive exam. To take the exam, there are following requirements:

- Minimum age limit is $X$ (i.e. Age should be greater than or equal to $X$).
- Age should be strictly less than $Y$.

Chef's current Age is $A$. Find whether he is currently eligible to take the exam or not.

### Input Format
- First line will contain $T$, number of test cases. Then the test cases follow.
- Each test case consists of a single line of input, containing three integers $X, Y,$ and $A$ as mentioned in the statement.
### Output Format
- For each test case, output YES if Chef is eligible to give the exam, NO otherwise.
### Sample 1:
Input
Output

```
2
21 34 30
25 31 31

```

```
YES
NO

```

### Explanation:

 **Test case $1$:**  The age of Chef is $30$. His age satisfies the minimum age limit as $30 \ge 21$. Also, it is less than the upper limit as $30 \lt 34$. Thus, Chef is eligible to take the exam.

 **Test case $2$:**  The age of Chef is $31$. His age satisfies the minimum age limit as $31 \ge 25$. But, it is not less than the upper limit as $31 \nless 31$. Thus, Chef is not eligible to take the exam.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-01T14:00:14.946Z  

```py
T = int(input())

for _ in range(T):
    X, Y, A = map(int, input().split())

    if X <= A < Y:
        print("YES")
    else:
        print("NO")
```

---

[View on CodeChef](https://www.codechef.com/problems/CS02A)