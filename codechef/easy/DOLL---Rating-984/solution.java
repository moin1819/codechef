
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int count = 0;

            for (int i = 0; i < N; i++) {
                int H = sc.nextInt();

                if (H > K) {
                    count++;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}
