import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Handle edge cases
        if (intervals.length <= 1) {
            return intervals;
        }

        // 2. Sort the intervals based on the start time
        // Using a lambda expression to compare the first element of each inner array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // 3. Initialize the first interval as the "anchor"
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // 4. Iterate through the intervals
        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            // If the next interval starts before or when the current one ends, merge them
            if (nextStart <= currentEnd) {
                // Update the current interval's end to the maximum end value
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, update the anchor to the next interval
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }

        // 5. Convert the list back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}