# Maximum Length Substring With Two Occurrences

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `s`, return the  **maximum**  length of a substring such that it contains  *at most two occurrences*  of each character.

 

 **Example 1:** 

 **Input:**  s = "bcbbbcba"

 **Output:**  4

 **Explanation:** 

The following substring has a length of 4 and contains at most two occurrences of each character: `"bcbbbcba"`.

 **Example 2:** 

 **Input:**  s = "aaaa"

 **Output:**  2

 **Explanation:** 

The following substring has a length of 2 and contains at most two occurrences of each character: `"aaaa"`.

 

 **Constraints:** 

- 2 <= s.length <= 100
- s consists only of lowercase English letters.

## Solution

**Language:** C  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 9.3 MB (beats 40.00%)  
**Submitted:** 2026-08-14T09:47:05.747Z  

```c
#include <string.h>
int maximumLengthSubstring(char* s) {
    int counts[26] = {0};
    int left = 0;
    int max_len = 0;
    int len = strlen(s);

    for (int right = 0; right < len; right++) {
        counts[s[right] - 'a']++;

        while (counts[s[right] - 'a'] > 2) {
            counts[s[left] - 'a']--;
            left++;
        }

        int curr_len = right - left + 1;
        if (curr_len > max_len) {
            max_len = curr_len;
        }
    }

    return max_len;
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/)