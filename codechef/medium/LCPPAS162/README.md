# LCPPAS162

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Product and Sum of digits

Given an integer  **N**, Calculate and print the  **sum**  and  **product**  of its digit.

### Input Format
- The first and only line of input will contain a single positive integer $N$ <= 109.
### Output Format
- Print the sum and product of digits of $N$ on single line with a space between them.
### Sample 1:
Input
Output

```
22
```

```
4 4
```

### Explanation:

For number = 22
sum of digits = 2 + 2 = 4
product of digits = 2 * 2 = 4

### Sample 2:
Input
Output

```
222
```

```
6 8
```

### Explanation:

For number = 222
sum of digits = 2 + 2 + 2 = 6
product of digits = 2  *2*  2 = 8

## Solution

**Language:** c_cpp  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-09T04:23:52.184Z  

```c_cpp
#include <iostream>
using namespace std;

int main() {
    long long N;
    cin >> N;
    
    long long sum = 0;
    long long product = 1;
    
    while (N > 0) {
        int digit = N % 10; 
        sum += digit;
        product *= digit;
        N /= 10;            
    }
    
    cout << sum << " " << product << endl;
    
    return 0;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LCPPAS162)