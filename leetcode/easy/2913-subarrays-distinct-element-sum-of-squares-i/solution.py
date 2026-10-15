class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        total_sum = 0
        n = len(nums)
        
        # Iterate over all possible starting points
        for i in range(n):
            distinct_elements = set()
            # Iterate over all possible ending points for a fixed starting point i
            for j in range(i, n):
                distinct_elements.add(nums[j])
                # Add the square of the count of distinct elements
                total_sum += len(distinct_elements) ** 2
                
        return total_sum