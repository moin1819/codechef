# ECHOECHO

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Echo

A string of length $4$ is called an  *echo*  if $S_1 = S_3$ and $S_2 = S_4$.
Here, we are using $1$-indexing.

You are given a string of length $4$. Check if it is an  *echo*.

### Input Format
- The first and only line of input will contain a single string $S$ of length $4$.
### Output Format

Print `Yes` if $S$ is an  *echo*, and `No` otherwise.

Each character of the output may be printed in either uppercase or lowercase, i.e. the strings `NO`, `No`, `nO`, and `no` will be treated as equivalent.

### Constraints
- $S$ has length $4$.
- $S$ consists of only lowercase English letters, i.e. the characters a, b, c,..., z.
### Sample 1:
Input
Output

```
meme

```

```
Yes

```

### Explanation:

The first and third characters of `meme` are both equal (to `m`), and its second and fourth characters are also both equal (to `e`).
So, `meme` is an  *echo*.

### Sample 2:
Input
Output

```
ever

```

```
No
```

### Explanation:

The second character of `ever` is `v`, while its fourth character is `r`. These are not equal, so `ever` is not an  *echo*.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T16:04:28.023Z  

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if (s.charAt(0) == s.charAt(2) && s.charAt(1) == s.charAt(3)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/ECHOECHO)