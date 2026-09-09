import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            String A = sc.next();
            String B = sc.next();

            int countA = 0;
            int countB = 0;

            for (char c : A.toCharArray()) {
                if (c == 'a') {
                    countA++;
                }
            }

            for (char c : B.toCharArray()) {
                if (c == 'a') {
                    countB++;
                }
            }

            if (countA + countB == N) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}