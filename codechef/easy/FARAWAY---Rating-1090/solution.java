
import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            long M = sc.nextLong();

            long ans = 0;

            for (int i = 0; i < N; i++) {
                long x = sc.nextLong();

                ans += Math.max(x - 1, M - x);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
