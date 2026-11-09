
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            long X = sc.nextLong();

            if (Math.abs(A - B) % (2 * X) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
