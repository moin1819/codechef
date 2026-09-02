import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int[] count = new int[31];

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                // Find position of highest set bit
                int highestBit = 31 - Integer.numberOfLeadingZeros(x);

                count[highestBit]++;
            }

            int answer = 0;

            for (int i = 0; i < 31; i++) {
                answer = Math.max(answer, count[i]);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}