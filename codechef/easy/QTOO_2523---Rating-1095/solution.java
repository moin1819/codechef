
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int ans = -1;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    if (s.charAt(i) == s.charAt(j)) {
                        ans = n - 2;
                        break;
                    }
                }

                if (ans != -1) {
                    break;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
