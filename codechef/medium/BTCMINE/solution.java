import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long X = sc.nextLong();
            long Y = sc.nextLong();

            long profit = 0;
            long gpu = 0;
            int days = 0;

            while (profit <= 0) {
                days++;
                if (Y * (2 * gpu + 1) > X) {
                    gpu++;
                    profit -= X;
                }
                profit += Y * gpu * gpu;
            }

            System.out.println(days);
        }

        sc.close();
    }
}