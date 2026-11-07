
import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        // Available servers: weight, index
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: free time, index
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Initially, all servers are available
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int j = 0; j < m; j++) {

            time = Math.max(time, j);

            // Move free servers into available heap
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();

                int index = (int) server[1];

                available.offer(
                    new int[]{servers[index], index}
                );
            }

            // If no server is available, wait
            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();

                    int index = (int) server[1];

                    available.offer(
                        new int[]{servers[index], index}
                    );
                }
            }

            // Select the best available server
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[j] = index;

            // Calculate when this server becomes free
            long freeTime = time + tasks[j];

            busy.offer(new long[]{freeTime, index});
        }

        return ans;
    }
}
