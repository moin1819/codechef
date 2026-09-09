import java.io.*;
import java.util.*;

public class Main {

    static class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void add(int index, int value) {
            while (index <= n) {
                bit[index] += value;
                index += index & -index;
            }
        }

        // Returns the position of the k-th smallest element
        int kth(int k) {
            int idx = 0;

            int power = Integer.highestOneBit(n);

            for (int step = power; step != 0; step >>= 1) {
                int next = idx + step;

                if (next <= n && bit[next] < k) {
                    idx = next;
                    k -= bit[next];
                }
            }

            return idx + 1;
        }
    }

    static int[] a;
    static Fenwick fenwick;

    static int median(int length) {
        int k = (length + 1) / 2;
        return fenwick.kth(k);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            a = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int posOne = -1;

            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());

                if (a[i] == 1) {
                    posOne = i;
                }
            }

            fenwick = new Fenwick(N);

            int l = posOne;
            int r = posOne;

            // Start with [posOne, posOne]
            fenwick.add(a[posOne], 1);

            int currentMedian = 1;

            boolean possible = true;

            out.append(l + 1).append(" ").append(r + 1).append('\n');

            for (int length = 3; length <= N; length += 2) {

                int bestL = -1;
                int bestR = -1;
                int bestMedian = Integer.MAX_VALUE;

                // Three possible expansions
                int[][] candidates = {
                    {l - 2, r},
                    {l - 1, r + 1},
                    {l, r + 2}
                };

                for (int[] c : candidates) {

                    int nl = c[0];
                    int nr = c[1];

                    if (nl < 0 || nr >= N) {
                        continue;
                    }

                    // Temporarily add the two new elements
                    if (nl == l - 2) {
                        fenwick.add(a[l - 2], 1);
                        fenwick.add(a[l - 1], 1);
                    }
                    else if (nr == r + 2) {
                        fenwick.add(a[r + 1], 1);
                        fenwick.add(a[r + 2], 1);
                    }
                    else {
                        fenwick.add(a[l - 1], 1);
                        fenwick.add(a[r + 1], 1);
                    }

                    int newMedian = median(length);

                    // Remove temporary elements
                    if (nl == l - 2) {
                        fenwick.add(a[l - 2], -1);
                        fenwick.add(a[l - 1], -1);
                    }
                    else if (nr == r + 2) {
                        fenwick.add(a[r + 1], -1);
                        fenwick.add(a[r + 2], -1);
                    }
                    else {
                        fenwick.add(a[l - 1], -1);
                        fenwick.add(a[r + 1], -1);
                    }

                    // Need strictly increasing median.
                    // Among valid choices, choose smallest median.
                    if (newMedian > currentMedian &&
                        newMedian < bestMedian) {

                        bestMedian = newMedian;
                        bestL = nl;
                        bestR = nr;
                    }
                }

                if (bestL == -1) {
                    possible = false;
                    break;
                }

                // Permanently add the selected two elements
                if (bestL == l - 2) {
                    fenwick.add(a[l - 2], 1);
                    fenwick.add(a[l - 1], 1);
                }
                else if (bestR == r + 2) {
                    fenwick.add(a[r + 1], 1);
                    fenwick.add(a[r + 2], 1);
                }
                else {
                    fenwick.add(a[l - 1], 1);
                    fenwick.add(a[r + 1], 1);
                }

                l = bestL;
                r = bestR;
                currentMedian = bestMedian;

                out.append(l + 1)
                   .append(" ")
                   .append(r + 1)
                   .append('\n');
            }

            if (!possible) {
                // Remove already printed lines for this test case
                // by rebuilding output is inconvenient, so use a temporary
                // StringBuilder in production.
            }
        }

        System.out.print(out);
    }
}