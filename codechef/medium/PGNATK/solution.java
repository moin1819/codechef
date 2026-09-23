import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // Every K-th minute is a delay.
            int delays = (N - 1) / (K - 1);

            System.out.println(N + delays);
        }
    }
}