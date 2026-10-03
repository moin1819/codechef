import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();

            long odd = (N + 1) / 2;
            long even = N / 2;

            long answer = 2 * odd * even;

            System.out.println(answer);
        }

        sc.close();
    }
}