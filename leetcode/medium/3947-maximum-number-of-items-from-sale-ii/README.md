# Maximum Number of Items From Sale II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a 2D integer array `items`, where `items[i] = [factori, pricei]` represents the `ith` item. You are also given an integer `budget`.

There are unlimited copies of each item available for purchase. You may buy any number of copies of any items such that the total cost of the purchased copies is at most `budget`.

After buying items, you may receive free copies according to the following rules:

- Each purchased copy of item i can give you at most one free copy of another item j.
- The free item must satisfy i != j and factori divides factorj.
- For each ordered pair (i, j), you can receive a free copy of item j from purchases of item i at most once, regardless of how many copies of item i you buy.
- The same item j can be received multiple times for free if it is received from purchases of different item types.

Return the  **maximum total number of item copies**  you can obtain, including both purchased copies and free copies, while spending at most `budget` on purchased items.

 

Original
Java
 **Example 1:** 

 **Input:**  items = [[1,6],[2,4],[3,5]], budget = 19

 **Output:**  5

 **Explanation:** 

- You can buy 2 copies of item 0 and 1 copy of item 1 for a total cost of 2 * 6 + 4 = 16, which is not greater than budget = 19.
- One purchased copy of item 0 gives 1 free copy of item 1, because factor0 = 1 divides factor1 = 2.
- The other purchased copy of item 0 gives 1 free copy of item 2, because factor0 = 1 divides factor2 = 3.
- You leave with 3 purchased copies and 2 free copies, for a total of 5 item copies.

 **Example 2:** 

 **Input:**  items = [[2,8],[1,10],[6,6],[4,12],[5,20],[5,17]], budget = 35

 **Output:**  7

 **Explanation:** 

- You can buy 2 copies of item 0, 1 copy of item 1, and 1 copy of item 2 for a total cost of 2 * 8 + 10 + 6 = 32, which is not greater than budget = 35.
- One purchased copy of item 0 gives 1 free copy of item 2, because factor0 = 2 divides factor2 = 6.
- The other purchased copy of item 0 gives 1 free copy of item 3, because factor0 = 2 divides factor3 = 4.
- The purchased copy of item 1 gives 1 free copy of item 2, because factor1 = 1 divides factor2 = 6.
- Buying item 2 gives no free copy, because factor2 = 6 does not divide the factor of any other item.
- You leave with 4 purchased copies and 3 free copies, for a total of 7 item copies.

 

 **Constraints:** 

- 1 <= items.length <= 105
- items[i] = [factori, pricei]
- 1 <= factori <= items.length
- 1 <= pricei <= 109
- 1 <= budget <= 109

## Solution

**Language:** Java  
**Runtime:** 66 ms (beats 32.65%)  
**Memory:** 221.4 MB (beats 87.76%)  
**Submitted:** 2026-11-28T08:02:03.231Z  

```java
class Solution {
    int minPrice;
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFac = 0;
        for (var item : items)
            maxFac = Math.max(maxFac, item[0]);
        int[] fre = new int[maxFac + 1];
        for (var item: items)
            fre[item[0]]++;
        for (int i = 1; i<=maxFac; i++) {
            if (fre[i] > 0) {
                for (int j = i*2; j<=maxFac; j+=i) {
                    fre[i] += fre[j];
                }
            }
        }
        
        Arrays.sort(items, (a,b) -> Integer.compare(a[1],b[1]));
        minPrice = items[0][1];

        int ans = 0;
        for (int i = 0; i<n; i++) {
            int price = items[i][1];
            // subtract copy of itself
            int copy = fre[items[i][0]] - 1;
            if (price - minPrice > minPrice)
                break;

            int take = Math.min(copy, budget/price);
            ans += (take * 2);
            budget -= (take * price);
        }
        ans += (budget/minPrice);
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/)