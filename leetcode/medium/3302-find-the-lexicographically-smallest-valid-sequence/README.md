# Find the Lexicographically Smallest Valid Sequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two strings `word1` and `word2`.

A string `x` is called  **almost equal**  to `y` if you can change  **at most**  one character in `x` to make it  *identical*  to `y`.

A sequence of indices `seq` is called  **valid**  if:

- The indices are sorted in ascending order.
- Concatenating the characters at these indices in word1 in the same order results in a string that is almost equal to word2.

Return an array of size `word2.length` representing the lexicographically smallest  **valid**  sequence of indices. If no such sequence of indices exists, return an  **empty**  array.

 **Note**  that the answer must represent the  *lexicographically smallest array*,  **not**  the corresponding string formed by those indices.

 

 **Example 1:** 

 **Input:**  word1 = "vbcca", word2 = "abc"

 **Output:**  [0,1,2]

 **Explanation:** 

The lexicographically smallest valid sequence of indices is `[0, 1, 2]`:

- Change word1[0] to 'a'.
- word1[1] is already 'b'.
- word1[2] is already 'c'.

 **Example 2:** 

 **Input:**  word1 = "bacdc", word2 = "abc"

 **Output:**  [1,2,4]

 **Explanation:** 

The lexicographically smallest valid sequence of indices is `[1, 2, 4]`:

- word1[1] is already 'a'.
- Change word1[2] to 'b'.
- word1[4] is already 'c'.

 **Example 3:** 

 **Input:**  word1 = "aaaaaa", word2 = "aaabc"

 **Output:**  []

 **Explanation:** 

There is no valid sequence of indices.

 **Example 4:** 

 **Input:**  word1 = "abc", word2 = "ab"

 **Output:**  [0,1]

 

 **Constraints:** 

- 1 <= word2.length < word1.length <= 3 * 105
- word1 and word2 consist only of lowercase English letters.

## Solution

**Language:** Python  
**Runtime:** 578 ms (beats 47.83%)  
**Memory:** 47.4 MB (beats 65.22%)  
**Submitted:** 2026-08-08T17:31:51.601Z  

```py
class Solution:
    def validSequence(self, word1: str, word2: str) -> list[int]:
        n1, n2 = len(word1), len(word2)
        
        # suffix[j] stores the largest index in word1 from which 
        # word2[j:] can be matched EXACTLY as a subsequence.
        suffix = [-1] * n2
        p1 = n1 - 1
        for j in range(n2 - 1, -1, -1):
            while p1 >= 0 and word1[p1] != word2[j]:
                p1 -= 1
            if p1 >= 0:
                suffix[j] = p1
                p1 -= 1
            else:
                break
        
        res = []
        changed = False
        i = 0
        
        for j in range(n2):
            while i < n1:
                is_match = (word1[i] == word2[j])
                can_finish_exact = (j == n2 - 1) or (suffix[j + 1] > i)
                
                if is_match:
                    if can_finish_exact or not changed:
                        res.append(i)
                        i += 1
                        break
                else:
                    if not changed and can_finish_exact:
                        res.append(i)
                        changed = True
                        i += 1
                        break
                
                i += 1
            else:
                return []
                
        return res
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/)