# QTOO_2523 - Rating 1095

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Bi_lindrome!

You are given a string $S$ of length $N$.

Your task is to delete a subsequence of  **maximum**  length from the string, such that, after concatenating the remaining parts of the string, it becomes a palindrome of length  **greater**  than $1$.

If this is possible, print the maximum length of the subsequence that can be deleted. Otherwise, print $-1$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of $2$ lines of input: The first line consists the a single integer $N$ - the length of string $S$. The second line contains string $S$, consisting of lowercase english alphabets.
### Output Format

For each test case, if it is possible to delete a subsequence under the given conditions, print a single integer, denoting the maximum length of the subsequence that can be deleted. Otherwise, print $-1$.

### Constraints
- $1 \leq T \leq 2500$
- $3 \leq N \leq 100$
- $S$ consists of lowercase english alphabets.
### Sample 1:
Input
Output

```
3
6
babkhj
3 
abc 
4 
qtoo
```

```
4
-1
2 

```

### Explanation:

 **Test case $1$:**  Possible ways to delete a subsequence are:

- Delete subsequence khj to get palindrome bab.
- Delete subsequence akhj to get palindrome bb.

The subsequence having maximum length that can be deleted is `akhj`, having length $4$.

 **Test case $2$:**  We cannot delete any subsequence under the given conditions.

 **Test case $3$:**  We can delete the subsequence `qt` to obtain the string `oo`, which is a palindrome. This is the only subsequence that can be deleted and it has length $2$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-20T13:26:02.950Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int ans = -1;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    if (s.charAt(i) == s.charAt(j)) {
                        ans = n - 2;
                        break;
                    }
                }

                if (ans != -1) {
                    break;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/QTOO_2523)