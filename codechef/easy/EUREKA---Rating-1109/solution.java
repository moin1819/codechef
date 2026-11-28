
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            double ans = Math.pow(0.143 * n, n);

            System.out.println(Math.round(ans));
        }

        sc.close();
    }
}
