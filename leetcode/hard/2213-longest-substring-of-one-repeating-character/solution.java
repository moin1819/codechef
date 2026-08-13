class Solution {
    private int[] prefLen;
    private int[] suffLen;
    private int[] maxLen;
    private char[] sArr;

    private void combine(int node, int l, int mid, int r) {
        int left = 2 * node;
        int right = 2 * node + 1;

        maxLen[node] = Math.max(maxLen[left], maxLen[right]);
        prefLen[node] = prefLen[left];
        suffLen[node] = suffLen[right];

        if (sArr[mid] == sArr[mid + 1]) {
            maxLen[node] = Math.max(maxLen[node], suffLen[left] + prefLen[right]);

            if (prefLen[left] == mid - l + 1) {
                prefLen[node] = prefLen[left] + prefLen[right];
            }
            if (suffLen[right] == r - mid) {
                suffLen[node] = suffLen[right] + suffLen[left];
            }
        }
    }

    private void build(int node, int l, int r) {
        prefLen[node] = 1;
        suffLen[node] = 1;
        maxLen[node] = 1;

        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        combine(node, l, mid, r);
    }

    private void update(int node, int l, int r, int idx, char ch) {
        if (l == r) {
            sArr[idx] = ch;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, r, idx, ch);
        }
        combine(node, l, mid, r);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.sArr = s.toCharArray();
        int n = s.length();
        int k = queryIndices.length;

        prefLen = new int[4 * n];
        suffLen = new int[4 * n];
        maxLen = new int[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            result[i] = maxLen[1];
        }

        return result;
    }
}