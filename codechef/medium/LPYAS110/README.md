# LPYAS110

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Print factorial

Write a program that uses a while loop to find the factorial of a given number.

What is the Factorial of an integer $N$?
A factorial is a function that multiplies a number by every number below it till 1.
For example, the factorial of 3 represents the multiplication of numbers 3, 2, 1, i.e. 3! = 3 × 2 × 1 and is equal to 6.

Check sample input / output below for more clarity.

### Input Format

Your code will be checked on multiple different inputs.

Each input contains only 1 integer $N$.

### Output Format

For each test file, output only the integer which is Factorial of $N$.

You do not need to output anything else.

### Sample 1:
Input
Output

```
5
```

```
120
```

### Explanation:

Factorial of 5 = 1  *2*  3  *4*  5 = 120

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-07T13:54:39.903Z  

```py

n = int(input())

factorial = 1
current = n

while current > 1:
    factorial *= current
    current -= 1
print(factorial)
```

---

[View on CodeChef](https://www.codechef.com/problems/LPYAS110)