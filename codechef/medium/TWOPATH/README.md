# TWOPATH

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Two Paths

You are given a grid with $N$ rows and $M$ columns. The cell in the $i$-th row from the top and $j$-th column from the left is denoted $(i, j)$, and has the integer $A_{i, j}$ written on it. Each $A_{i, j}$ is either $0, 1,$ or $2$.

A  *right-down path*  in this grid is a sequence of $N+M-1$ cells $(x_1, y_1), (x_2, y_2), \ldots, (x_{N+M-1}, y_{N+M-1})$ such that:

- $(x_1, y_1) = (1, 1)$
- $(x_{N+M-1}, y_{N+M-1}) = (N, M)$
- For each $1 \le i \lt N+M-1$, exactly one of the following two conditions holds: $x_{i+1} = x_{i}$ and $y_{i+1} = y_i + 1$, or $x_{i+1} = x_{i} + 1$ and $y_{i+1} = y_i$

The grid is called  *good*  if there exist  **two**  right-down paths such that:

- The paths are different, i.e. each path contains a cell not in the other; and
- For every cell $(i, j)$ in the grid, at most $A_{i, j}$ of the two paths contain this cell.

You would like to make the given grid  *good*.
So, you can do the following:

- Choose a row or a column of the grid, change every instance of $1$ in the chosen row/column to $2$.

Find the minimum number of moves needed to make the given grid  *good*.
If it's not possible to make the grid  *good*  no matter what, print $-1$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line of each test case contains two space-separated integers $N$ and $M$ — the grid dimensions. The next $N$ lines describe the grid. The $i$-th of these $N$ lines contains $M$ space-separated integers $A_{i, 1}, A_{i, 2}, \ldots, A_{i, M}$.
### Output Format

For each test case, output on a new line the minimum number of operations needed to make the grid  *good*, or $-1$ if it's impossible to do so.

### Constraints
- $1 \leq T \leq 10^5$
- $1 \leq N, M \leq 2\cdot 10^5$
- $1 \le NM \le 2\cdot 10^5$
- $A_{i, j} \in \{0, 1, 2\}$
- The sum of $NM$ over all test cases won't exceed $2\cdot 10^5$.
### Sample 1:
Input
Output

```
6
2 2
1 1
1 1
2 4
1 0 0 0
2 1 2 1
3 5
2 1 0 0 0
1 1 1 1 1
0 0 1 1 2
4 3
2 0 2
0 0 0
2 0 2
2 0 2
4 5
1 1 0 0 0
1 1 1 0 0
0 0 1 1 0
0 0 0 1 1
2 6
2 2 2 2 2 2
2 2 2 2 2 2

```

```
2
-1
1
-1
4
0

```

### Explanation:

 **Test case $1$:**  We have a $2\times 2$ grid. The only way to have two different paths from $(1, 1)$ to $(2, 2)$ is for us to use $(1, 1) \to (1, 2) \to (2, 2)$ and $(1, 1) \to (2, 1) \to (2, 2)$.
These paths can both be valid only if $A_{1, 1}$ and $A_{2, 2}$ are both $2$ (and the other cells are at least $1$, which they are).

We need to increment both $A_{1, 1}$ and $A_{2, 2}$, which requires two moves - it cannot be done in $1$.

 **Test case $2$:**  Since the cells $(1, 2), (1, 3), (1, 4)$ are not usable, only a single unique path can exist from $(1, 1)$ to $(2, 4)$, so the answer is $-1$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T16:24:00.073Z  

```java
import java.io.*;
import java.util.*;

class Main {

    static int N, M, V;
    static int[][] a;

    static int LOG = 20;

    // Dominator tree
    static int[] idom;
    static int[] depth;
    static int[][] up;

    // Matching
    static int[] pairRow;
    static int[] pairCol;
    static int[] dist;

    static int id(int r, int c) {
        return r * M + c;
    }

    // ---------- LCA on dominator tree ----------

    static void buildNode(int v, int parent) {
        idom[v] = parent;
        depth[v] = depth[parent] + 1;

        up[0][v] = parent;

        for (int j = 1; j < LOG; j++) {
            up[j][v] = up[j - 1][up[j - 1][v]];
        }
    }

    static int lca(int u, int v) {
        if (u == v) {
            return u;
        }

        if (depth[u] < depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    // ---------- Hopcroft-Karp ----------

    static boolean bfs(ArrayList<Integer>[] graph, int rows) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            if (pairRow[r] == -1) {
                dist[r] = 0;
                q.add(r);
            } else {
                dist[r] = -1;
            }
        }

        boolean found = false;

        while (!q.isEmpty()) {
            int r = q.poll();

            for (int c : graph[r]) {
                int next = pairCol[c];

                if (next == -1) {
                    found = true;
                } else if (dist[next] == -1) {
                    dist[next] = dist[r] + 1;
                    q.add(next);
                }
            }
        }

        return found;
    }

    static boolean dfs(int r, ArrayList<Integer>[] graph) {
        for (int c : graph[r]) {
            int next = pairCol[c];

            if (next == -1 ||
                (dist[next] == dist[r] + 1 && dfs(next, graph))) {

                pairRow[r] = c;
                pairCol[c] = r;
                return true;
            }
        }

        dist[r] = -1;
        return false;
    }

    static int maximumMatching(ArrayList<Integer>[] graph, int rows, int cols) {
        pairRow = new int[rows];
        pairCol = new int[cols];
        dist = new int[rows];

        Arrays.fill(pairRow, -1);
        Arrays.fill(pairCol, -1);

        int matching = 0;

        while (bfs(graph, rows)) {
            for (int r = 0; r < rows; r++) {
                if (pairRow[r] == -1 && dfs(r, graph)) {
                    matching++;
                }
            }
        }

        return matching;
    }

    // ---------- Main solution ----------

    static int solve() {

        /*
         * First check whether (1,1) -> (N,M) is possible
         * using only cells with value > 0.
         */
        boolean[][] reachable = new boolean[N][M];

        if (a[0][0] == 0 || a[N - 1][M - 1] == 0) {
            return -1;
        }

        reachable[0][0] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (a[i][j] == 0) {
                    continue;
                }

                if (i == 0 && j == 0) {
                    continue;
                }

                boolean ok = false;

                if (i > 0 && reachable[i - 1][j]) {
                    ok = true;
                }

                if (j > 0 && reachable[i][j - 1]) {
                    ok = true;
                }

                reachable[i][j] = ok;
            }
        }

        if (!reachable[N - 1][M - 1]) {
            return -1;
        }

        /*
         * Build dominator tree.
         *
         * Only reachable cells matter.
         */
        V = N * M;

        idom = new int[V];
        depth = new int[V];
        up = new int[LOG][V];

        Arrays.fill(idom, -1);

        int source = id(0, 0);

        idom[source] = source;
        depth[source] = 0;

        for (int j = 0; j < LOG; j++) {
            up[j][source] = source;
        }

        /*
         * Row-major order is a valid topological order because
         * every edge comes from either the top or left.
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (!reachable[i][j]) {
                    continue;
                }

                if (i == 0 && j == 0) {
                    continue;
                }

                int p1 = -1;
                int p2 = -1;

                if (i > 0 && reachable[i - 1][j]) {
                    p1 = id(i - 1, j);
                }

                if (j > 0 && reachable[i][j - 1]) {
                    p2 = id(i, j - 1);
                }

                int parent;

                if (p1 == -1) {
                    parent = p2;
                } else if (p2 == -1) {
                    parent = p1;
                } else {
                    parent = lca(p1, p2);
                }

                buildNode(id(i, j), parent);
            }
        }

        /*
         * All dominators of the destination are exactly the nodes
         * on the path from destination to source in the dominator tree.
         */
        int target = id(N - 1, M - 1);

        ArrayList<Integer> critical = new ArrayList<>();

        int cur = target;

        while (true) {
            int r = cur / M;
            int c = cur % M;

            if (a[r][c] == 1) {
                critical.add(cur);
            }

            if (cur == source) {
                break;
            }

            cur = idom[cur];
        }

        /*
         * We now need the minimum number of rows/columns that cover
         * all critical cells whose value is 1.
         *
         * Build bipartite graph:
         *     left  = rows
         *     right = columns
         *     edge (r,c) = critical cell (r,c)
         */
        ArrayList<Integer>[] graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int cell : critical) {
            int r = cell / M;
            int c = cell % M;

            graph[r].add(c);
        }

        /*
         * Duplicate edges are impossible because every cell occurs once.
         */
        return maximumMatching(graph, N, M);
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {

            N = fs.nextInt();
            M = fs.nextInt();

            a = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    a[i][j] = fs.nextInt();
                }
            }

            out.append(solve()).append('\n');
        }

        System.out.print(out);
    }

    // ---------- Fast Scanner ----------

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int res = 0;

            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }

            return res * sign;
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/TWOPATH)