import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            int len = N - K;
            int currentSum = 0;
            for (int i = 0; i < len; i++) {
                currentSum += A[i];
            }

            int maxSum = currentSum;

            for (int i = len; i < N; i++) {
                currentSum += A[i];
                currentSum -= A[i - len];

                maxSum = Math.max(maxSum, currentSum);
            }

            System.out.println(maxSum);
        }

        sc.close();
    }
}