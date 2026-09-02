# CS00

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Module on basic conditional statements

We have reviewed programming problems on basic math in the previous module.
We now incorporate conditional statements in our problem solving capabilities along with basic math.

Just a recap on what we covered in Learn Python learning path regarding conditional statements.

- "if" and "else" can be used together to create conditions.
- Python relies on indentation (whitespace at the beginning of a line) to define scope in the code.
- The "elif" keyword means "if the previous conditions were not true, then try this condition"
- The "else" keyword includes all cases which aren't included in the previous conditions.
- Usual conditions used within if / else / elif statements Equals: a == b Not Equals: a != b Less than: a < b Less than or equal to: a <= b Greater than: a > b Greater than or equal to: a >= b
- "and" and "or" statements help check multiple conditions

Revise some of this syntax in the IDE.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-02T15:29:31.598Z  

```py
#Click on 'Submit' to first see the results
#Click on 'Next to continue'

# if, else statement and indentation
a = 13
b = 15
if a >= b:
    #do not forget the indentation!!!
    print(a, 'is greater than or equal to', b)        
else:
    #do not forget the indentation!!!
    print(a, 'is lesser than', b)

# lets add the elif statement
a = 14
b = 14
if a > b:
    print(a, 'is greater than', b)
elif a == b:
    print(a, 'is equal to', b)
else:
    print(a, 'is lesser than', b)

```

---

[View on CodeChef](https://www.codechef.com/problems/CS00)