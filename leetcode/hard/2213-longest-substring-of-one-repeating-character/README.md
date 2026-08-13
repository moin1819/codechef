# Longest Substring of One Repeating Character

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a  **0-indexed**  string `s`. You are also given a  **0-indexed**  string `queryCharacters` of length `k` and a  **0-indexed**  array of integer  **indices**  `queryIndices` of length `k`, both of which are used to describe `k` queries.

The `ith` query updates the character in `s` at index `queryIndices[i]` to the character `queryCharacters[i]`.

Return  *an array*  `lengths`  *of length* `k` *where*  `lengths[i]`  *is the  **length**  of the  **longest substring**  of* `s` *consisting of  **only one repeating**  character  **after**  the*  `ith`  *query** is performed.* 

 

 **Example 1:** 

```
Input: s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3]
Output: [3,3,4]
Explanation: 
- 1st query updates s = "bbbacc". The longest substring consisting of one repeating character is "bbb" with length 3.
- 2nd query updates s = "bbbccc". 
  The longest substring consisting of one repeating character can be "bbb" or "ccc" with length 3.
- 3rd query updates s = "bbbbcc". The longest substring consisting of one repeating character is "bbbb" with length 4.
Thus, we return [3,3,4].

```

 **Example 2:** 

```
Input: s = "abyzz", queryCharacters = "aa", queryIndices = [2,1]
Output: [2,3]
Explanation:
- 1st query updates s = "abazz". The longest substring consisting of one repeating character is "zz" with length 2.
- 2nd query updates s = "aaazz". The longest substring consisting of one repeating character is "aaa" with length 3.
Thus, we return [2,3].

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of lowercase English letters.
- k == queryCharacters.length == queryIndices.length
- 1 <= k <= 105
- queryCharacters consists of lowercase English letters.
- 0 <= queryIndices[i] < s.length

## Solution

**Language:** Java  
**Runtime:** 91 ms (beats 89.06%)  
**Memory:** 114.3 MB (beats 57.81%)  
**Submitted:** 2026-08-13T08:40:38.457Z  

```java
class Solution {
    private int[] prefLen;
    private int[] suffLen;
    private int[] maxLen;
    private char[] sArr;

    private void combine(int node, int l, int mid, int r) {
        int left = 2 * node;
        int right = 2 * node + 1;

        maxLen[node] = Math.max(maxLen[left], maxLen[right]);
        prefLen[node] = prefLen[left];
        suffLen[node] = suffLen[right];

        if (sArr[mid] == sArr[mid + 1]) {
            maxLen[node] = Math.max(maxLen[node], suffLen[left] + prefLen[right]);

            if (prefLen[left] == mid - l + 1) {
                prefLen[node] = prefLen[left] + prefLen[right];
            }
            if (suffLen[right] == r - mid) {
                suffLen[node] = suffLen[right] + suffLen[left];
            }
        }
    }

    private void build(int node, int l, int r) {
        prefLen[node] = 1;
        suffLen[node] = 1;
        maxLen[node] = 1;

        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        combine(node, l, mid, r);
    }

    private void update(int node, int l, int r, int idx, char ch) {
        if (l == r) {
            sArr[idx] = ch;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, r, idx, ch);
        }
        combine(node, l, mid, r);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.sArr = s.toCharArray();
        int n = s.length();
        int k = queryIndices.length;

        prefLen = new int[4 * n];
        suffLen = new int[4 * n];
        maxLen = new int[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            result[i] = maxLen[1];
        }

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-of-one-repeating-character/)