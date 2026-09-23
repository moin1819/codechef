import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();
            long A = sc.nextLong();
            long B = sc.nextLong();
            long C = sc.nextLong();

            long answer = Long.MAX_VALUE;

            for (long Y = 1; Y <= N; Y++) {

                // Number of sprays required
                long Z = (N + Y - 1) / Y;

                long X;

                if (Z == 1) {
                    // One spray covers the entire house.
                    X = 1;
                } else {
                    // Minimum movement needed between sprays.
                    long distance = N - Y;
                    long moves = Z - 1;

                    X = (distance + moves - 1) / moves;
                }

                long cost = A * X + B * Y + C * Z;

                answer = Math.min(answer, cost);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}