class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        i0 = nums.index(0)

        inc = True
        dec = True

        for i in range(n):
            if nums[(i + 1) % n] != (nums[i] + 1) % n:
                inc = False

            if nums[(i + 1) % n] != (nums[i] - 1) % n:
                dec = False

        if inc:
            return min(i0, n - i0 + 2)

        if dec:
            return min(i0 + 2, n - i0)

        return -1