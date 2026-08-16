# LARGODDSTRIN

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Largest Odd Substring

You are given a string $nums$ consisting of digits representing a large integer. Your task is to find the largest-valued  **odd integer**  (as a substring of $nums$) that can be obtained.

A  **substring**  is a contiguous sequence of characters within the string.

## Function Declaration
### Function Name

$findLargestOddSubstring$ – This function finds the largest-valued odd integer that can be obtained as a substring of the given numeric string.

### Parameters
- $num$ : A string representing a large integer, consisting only of digits ($0–9$).
### Return Value
- This function prints: The largest odd integer substring if it exists. $-1$ if no odd integer substring can be formed.
## Constraints
- $1 \le |num| \le 10^5$
- The string $num$ contains only digits $0–9$
- The string does not contain leading zeros
- There is no limit on the size of the integer represented by the substring
### Input Format
- The first line contains a single string num.
### Output Format
- Print a single line: The largest odd integer substring of num Or -1 if no odd substring exists
### Sample 1:
Input
Output

```
128764

```

```
1287

```

### Explanation:

The largest odd substring ends at the first odd digit from the right, which is '7'.

### Sample 2:
Input
Output

```
60042

```

```
-1

```

### Explanation:

There are no odd digits in the string, so no odd substring exists.

### Sample 3:
Input
Output

```
987654321

```

```
987654321

```

### Explanation:

The last digit is '1', which is odd, so the entire number is the largest odd substring.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-16T06:20:10.579Z  

```java
public static String findLargestOddSubstring(String num) {
    if (num == null) {
        return "-1";
    }

    for (int i = num.length() - 1; i >= 0; i--) {
        int digit = num.charAt(i) - '0';

        if (digit % 2 != 0) {
            return num.substring(0, i + 1); // Returns the result instead of printing
        }
    }

    return "-1"; // Returns fallback instead of printing
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LARGODDSTRIN)