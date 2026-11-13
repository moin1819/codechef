
from collections import deque
from typing import List

class Solution:
    def countNonDecreasingSubarrays(self, nums: List[int], k: int) -> int:
        starts = deque()
        ans = 0
        water = 0
        r = len(nums) - 1

        for l in range(len(nums) - 1, -1, -1):
            x = nums[l]

            while starts and nums[starts[0]] <= x:
                s = starts.popleft()
                end = starts[0] if starts else r + 1

                water += (x - nums[s]) * (end - s)

            starts.appendleft(l)

            while water > k:
                water -= nums[starts[-1]] - nums[r]

                if starts[-1] == r:
                    starts.pop()

                r -= 1

            ans += r - l + 1

        return ans
