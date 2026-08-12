import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int N = sc.nextInt();
                long[] A = new long[N];
                long totalSum = 0;

                for (int i = 0; i < N; i++) {
                    A[i] = sc.nextLong();
                    totalSum += A[i];
                }

                if (totalSum % 2 != 0) {
                    System.out.println(0);
                } else {
                    long aliceChocolates = 0;
                    for (int i = 0; i < N; i++) {
                        aliceChocolates += A[i] - (A[i] % 2);
                    }
                    aliceChocolates += 1;
                    System.out.println(aliceChocolates);
                }
            }
        }
        sc.close();
    }
}