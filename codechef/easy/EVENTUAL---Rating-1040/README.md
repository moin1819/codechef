# EVENTUAL - Rating 1040

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Even-tual Reduction

You are given a string $S$ with length $N$. You may perform the following operation any number of times: choose a non-empty substring of $S$ (possibly the whole string $S$) such that each character occurs an even number of times  **in this substring**  and erase this substring from $S$. (The parts of $S$ before and after the erased substring are concatenated and the next operation is performed on this shorter string.)

For example, from the string "ac **abba** d", we can erase the highlighted substring "abba", since each character occurs an even number of times in this substring. After this operation, the remaining string is "acd".

Is it possible to erase the whole string using one or more operations?

Note: A string $B$ is a substring of a string $A$ if $B$ can be obtained from $A$ by deleting several (possibly none or all) characters from the beginning and several (possibly none or all) characters from the end.

### Input
- The first line of the input contains a single integer $T$ denoting the number of test cases. The description of $T$ test cases follows.
- The first line of each test case contains a single integer $N$.
- The second line contains a single string $S$ with length $N$.
### Output

For each test case, print a single line containing the string `"YES"` if it is possible to erase the whole string or `"NO"` otherwise (without quotes).

### Constraints
- $1 \le T \le 200$
- $1 \le N \le 1,000$
- $S$ contains only lowercase English letters
### Sample 1:
Input
Output

```
4
6
cabbac
7
acabbad
18
fbedfcbdaebaaceeba
21
yourcrushlovesyouback
```

```
YES
NO
YES
NO
```

### Explanation:

 **Example case 1:**  We can perform two operations: erase the substring "abba", which leaves us with the string "cc", and then erase "cc".

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T18:46:42.449Z  

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String tLine = reader.readLine();
        if (tLine == null) return;
        int T = Integer.parseInt(tLine.trim());
        
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine().trim());
            String S = reader.readLine().trim();

            int[] freq = new int[26];
            for (int i = 0; i < N; i++) {
                freq[S.charAt(i) - 'a']++;
            }

            boolean possible = true;
            for (int count : freq) {
                if (count % 2 != 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/EVENTUAL)