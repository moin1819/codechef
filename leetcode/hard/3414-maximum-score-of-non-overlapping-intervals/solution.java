import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.r != b.r) {
                return Integer.compare(a.r, b.r);
            }
            return Integer.compare(a.idx, b.idx);
        });

        int[] previous = new int[n];

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = i - 1;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid].r < arr[i].l) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            previous[i] = ans;
        }

        State[] prevDP = new State[n + 1];

        for (int i = 0; i <= n; i++) {
            prevDP[i] = new State(0, new int[0]);
        }

        State answer = prevDP[n];

        for (int k = 1; k <= 4; k++) {

            State[] currDP = new State[n + 1];

            currDP[0] = new State(0, new int[0]);

            for (int i = 1; i <= n; i++) {

                State skip = currDP[i - 1];

                int p = previous[i - 1];

                State before = prevDP[p + 1];

                int[] taken = new int[before.indices.length + 1];

                for (int j = 0; j < before.indices.length; j++) {
                    taken[j] = before.indices[j];
                }

                taken[before.indices.length] = arr[i - 1].idx;

                Arrays.sort(taken);

                State take = new State(
                    before.score + arr[i - 1].w,
                    taken
                );

                if (better(take, skip)) {
                    currDP[i] = take;
                } else {
                    currDP[i] = skip;
                }
            }

            if (better(currDP[n], answer)) {
                answer = currDP[n];
            }

            prevDP = currDP;
        }

        return answer.indices;
    }

    static boolean better(State a, State b) {

        if (a.score != b.score) {
            return a.score > b.score;
        }

        int len = Math.min(a.indices.length, b.indices.length);

        for (int i = 0; i < len; i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i];
            }
        }

        return a.indices.length < b.indices.length;
    }
}