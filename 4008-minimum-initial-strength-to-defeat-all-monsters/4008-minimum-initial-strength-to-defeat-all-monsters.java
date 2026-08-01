class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int len = monsters.length;
        
        long[] diffArr = new long[len + 1];
        for (int[] b : boosts) {
            int start = b[0];
            int end = b[1];
            long val = (long) b[2];
            
            diffArr[start] += val;
            diffArr[end + 1] -= val;
        }
        
        long[] totalBoosts = new long[len];
        long runningBoost = 0;
        long upperBound = 0;
        
        for (int i = 0; i < len; i++) {
            runningBoost += diffArr[i];
            totalBoosts[i] = runningBoost;
            upperBound += (long) monsters[i];
        }
        
        long left = 0;
        long right = upperBound;
        long minStrength = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (checkFeasibility(mid, monsters, totalBoosts)) {
                minStrength = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return minStrength;
    }
    
    private boolean checkFeasibility(long initial, int[] m, long[] b) {
        long current = initial;
        
        for (int i = 0; i < m.length; i++) {
            if (current + b[i] < m[i]) {
                return false;
            }
            current = Math.max(0L, current - m[i]);
        }
        
        return true;
    }
}