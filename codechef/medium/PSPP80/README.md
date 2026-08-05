# PSPP80

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Parameters, Arguments

Listen

Note that there is a difference between 'PARAMETERS' and 'ARGUMENTS'.
'Arguments' are actual values passed to a function.

Check the code template below

```
# `a`, `b` are `Parameters` inside the function
# `A`, `B` are `Arguments` passed to the function

def add_numbers(a, b):
    return a + b

# Calling the function with arguments
A = 5
B = 3
result = add_numbers(A, B)
print("Sum:", result)

```

### Task

The code given in the IDE is incorrect.
Can you debug the code to give the correct output?
Check the input and expected output below.

### Sample 1:
Input
Output

```
 
```

```
Hello, Alice!
```

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-05T07:56:27.254Z  

```py
def greet(name):
    return f"Hello, {name}!"

user_name = "Alice"
result = greet(user_name)
print(result)
```

---

[View on CodeChef](https://www.codechef.com/problems/PSPP80)