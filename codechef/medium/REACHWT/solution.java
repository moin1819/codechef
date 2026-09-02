import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int cost = (N / 2) * 30;

            if (N % 2 != 0) {
                cost += 20;
            }

            System.out.println(cost);
        }

        sc.close();
    }
}