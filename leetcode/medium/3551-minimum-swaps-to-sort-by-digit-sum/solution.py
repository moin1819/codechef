class Solution:
    def minSwaps(self, nums: list[int]) -> int:
        def get_digit_sum(n: int) -> int:
            return sum(int(c) for c in str(n))
        
        n = len(nums)
        
        # Sort nums based on digit sum (primary) and value (secondary)
        sorted_nums = sorted(nums, key=lambda x: (get_digit_sum(x), x))
        
        # Map each value to its target index in the sorted array
        val_to_index = {val: i for i, val in enumerate(sorted_nums)}
        
        visited = [False] * n
        swaps = 0
        
        for i in range(n):
            if visited[i] or nums[i] == sorted_nums[i]:
                continue
            
            # Traverse the cycle
            cycle_length = 0
            curr = i
            while not visited[curr]:
                visited[curr] = True
                curr = val_to_index[nums[curr]]
                cycle_length += 1
            
            if cycle_length > 1:
                swaps += (cycle_length - 1)
                
        return swaps