
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int pos1 = 0, posN = 0;

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                if (x == 1) {
                    pos1 = i;
                }
                if (x == N) {
                    posN = i;
                }
            }

            int ans = pos1 + (N - 1 - posN);

            if (pos1 > posN) {
                ans--;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
