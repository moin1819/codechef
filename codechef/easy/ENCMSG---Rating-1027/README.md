# ENCMSG - Rating 1027

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Encoding Message

Chef recently graduated Computer Science in university, so he was looking for a job. He applied for several job offers, but he eventually settled for a software engineering job at ShareChat. Chef was very enthusiastic about his new job and the first mission assigned to him was to implement a message encoding feature to ensure the chat is private and secure.

Chef has a message, which is a string $S$ with length $N$ containing only lowercase English letters. It should be encoded in two steps as follows:

- Swap the first and second character of the string $S$, then swap the 3rd and 4th character, then the 5th and 6th character and so on. If the length of $S$ is odd, the last character should not be swapped with any other.
- Replace each occurrence of the letter 'a' in the message obtained after the first step by the letter 'z', each occurrence of 'b' by 'y', each occurrence of 'c' by 'x', etc, and each occurrence of 'z' in the message obtained after the first step by 'a'.

The string produced in the second step is the encoded message. Help Chef and find this message.

### Input
- The first line of the input contains a single integer $T$ denoting the number of test cases. The description of $T$ test cases follows.
- The first line of each test case contains a single integer $N$.
- The second line contains the message string $S$.
### Output

For each test case, print a single line containing one string — the encoded message.

### Constraints
- $1 \le T \le 1,000$
- $1 \le N \le 100$
- $|S| = N$
- $S$ contains only lowercase English letters
### Sample 1:
Input
Output

```
2
9
sharechat
4
chef

```

```
shizxvzsg
sxuv
```

### Explanation:

 **Example case 1:**  The original message is "sharechat". In the first step, we swap four pairs of letters (note that the last letter is not swapped), so it becomes "hsraceaht". In the second step, we replace the first letter ('h') by 's', the second letter ('s') by 'h', and so on, so the resulting encoded message is "shizxvzsg".

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-24T12:26:42.474Z  

```py
import sys

def solve():
    input = sys.stdin.read
    data = input().split()
    if not data:
        return
    
    T = int(data[0])
    idx = 1
    
    for _ in range(T):
        N = int(data[idx])
        S = list(data[idx + 1])
        idx += 2
        
        # Step 1: Swap adjacent pairs
        for i in range(0, N - 1, 2):
            S[i], S[i + 1] = S[i + 1], S[i]
            
        # Step 2: Mirror alphabet transformation
        for i in range(N):
            S[i] = chr(ord('z') - (ord(S[i]) - ord('a')))
            
        print("".join(S))

if __name__ == "__main__":
    solve()
```

---

[View on CodeChef](https://www.codechef.com/problems/ENCMSG)