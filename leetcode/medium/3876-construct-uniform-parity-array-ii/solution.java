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

        // Already all odd or all even
        if (!hasOdd || !hasEven) {
            return true;
        }

        // Try to make all numbers odd
        for (int x : nums1) {
            if (x % 2 == 0 && x <= minOdd) {
                return false;
            }
        }

        return true;  // <-- You were missing this
    }
}