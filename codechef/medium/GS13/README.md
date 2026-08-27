# GS13

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Number mirror - Negative integer

Listen

Introducing Listen to Problem✨

Don't want to read? Now you can listen to the problem!

Let us now solve some programming problems. Note that

- In the IDE - # - comments will give you hints about what you need to do
- The Solution tab also has # - comments which give you helpful information
### Task

Write a program in the IDE which does the following

- Accepts the count of test cases - $t$ - in the 1st line The only line of each test case consists of an integer $N$
- You need to generate the following output - Change the sign of $N$. That is, if the input is $4$, output $-4$. If the input is $-5$, output $5$.
### Sample 1:
Input
Output

```
5
1
2
3
-4
-5
```

```
-1
-2
-3
4
5
```

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-27T04:20:53.353Z  

```py
# Accept the number of test cases
t = int(input())

# Loop through each test case
for _ in range(t):
    # Read the integer N for the current test case
    n = int(input())
    
    # Output the number with its sign flipped
    print(-n)
```

---

[View on CodeChef](https://www.codechef.com/problems/GS13)