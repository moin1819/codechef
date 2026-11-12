
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int ans = ((N + 1) / 2) * ((M + 1) / 2);

            System.out.println(ans);
        }

        sc.close();
    }
}
