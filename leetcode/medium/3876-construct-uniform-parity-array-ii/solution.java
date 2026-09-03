class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;
        boolean hasEven = false;

        for (int x : nums1) {
            if (x % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
                minOdd = Math.min(minOdd, x);
            }
        }
        if (!hasOdd || !hasEven) {
            return true;
        }

        for (int x : nums1) {
            if (x % 2 == 0 && x <= minOdd) {
                return false;
            }
        }

        return true;  
    }
}