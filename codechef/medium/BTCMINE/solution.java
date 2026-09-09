import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            long profit = 0;
            int gpu = 0;
            int days = 0;

            while (profit <= 0) {
                days++;

                // Buy one GPU
                gpu++;

                // Mining income for this day
                profit += (long) Y * gpu * gpu;

                // Cost of GPU
                profit -= X;
            }

            System.out.println(days);
        }

        sc.close();
    }
}