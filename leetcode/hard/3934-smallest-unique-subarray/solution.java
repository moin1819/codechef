class Solution {
    private boolean check(int len, int[] nums){
        HashMap<Long, Integer> map = new HashMap<>();
        long base=1_000_003L;
        long hash=0, pow=1;
        for (int i=0; i < len; i++) {
            hash=hash*base + nums[i];
            if (i>0) pow *= base;
        }
        map.put(hash, 1);
        for (int i = len; i < nums.length; i++) {
            hash=(hash - nums[i - len] * pow) * base + nums[i];
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        for (int count : map.values()) {
            if (count == 1) return true;
        }
        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        int n=nums.length;
        int low=1;
        int high=n;
        int ans=n;
        while(low<high){
            int mid=low+(high-low)/2;
            if(check(mid, nums)){
                high=mid;
                ans=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}