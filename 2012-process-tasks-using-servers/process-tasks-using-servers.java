import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < servers.length; i++) {
            free.offer(new int[]{servers[i], i});
        }

        int m = tasks.length;
        int[] ans = new int[m];
        long time = 0;
        int j = 0;

        while (j < m) {
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();
                free.offer(new int[]{(int) server[1], (int) server[2]});
            }

            if (free.isEmpty()) {
                time = busy.peek()[0];
                continue;
            }

            while (!free.isEmpty() && j < m && j <= time) {
                int[] server = free.poll();
                ans[j] = server[1];
                busy.offer(new long[]{time + tasks[j], server[0], server[1]});
                j++;
            }

            time++;
        }

        return ans;
    }
}