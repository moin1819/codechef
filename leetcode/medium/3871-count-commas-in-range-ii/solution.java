class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long threshold = 1000L;
        
        while (n >= threshold) {
            totalCommas += (n - threshold + 1);
            
            // Prevent overflow before multiplying threshold by 1000
            if (threshold > Long.MAX_VALUE / 1000) {
                break;
            }
            threshold *= 1000L;
        }
        
        return totalCommas;
    }
}