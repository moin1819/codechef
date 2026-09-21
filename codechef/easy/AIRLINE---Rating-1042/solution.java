import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            String S = sc.next();

            int zeros = 0;
            int ones = 0;

            for (char c : S.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            int answer = Math.min(ones, zeros + 1);

            System.out.println(answer);
        }

        sc.close();
    }
}