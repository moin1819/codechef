
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            String S = sc.next();
            String R = sc.next();

            int countS = 0;
            int countR = 0;

            for (int i = 0; i < N; i++) {
                if (S.charAt(i) == '1') {
                    countS++;
                }

                if (R.charAt(i) == '1') {
                    countR++;
                }
            }

            if (countS == countR) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
