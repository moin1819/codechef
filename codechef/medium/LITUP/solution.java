import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] C = new int[N];

            for (int i = 0; i < N; i++) {
                C[i] = sc.nextInt();
            }

            int ans = Integer.MAX_VALUE;

            // Try every pair of lights
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {

                    boolean possible = true;

                    // Check every stall
                    for (int x = 0; x < N; x++) {
                        boolean light1 = Math.abs(i - x) <= K;
                        boolean light2 = Math.abs(j - x) <= K;

                        if (!light1 && !light2) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        ans = Math.min(ans, C[i] + C[j]);
                    }
                }
            }

            if (ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }

        sc.close();
    }
}