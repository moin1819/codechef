
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int prev = sc.nextInt();
            int ans = 0;

            for (int i = 1; i < n; i++) {
                int curr = sc.nextInt();

                ans += Math.abs(curr - prev) - 1;

                prev = curr;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
