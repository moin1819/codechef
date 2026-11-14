
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int S = sc.nextInt();

            int pos = X;

            for (int i = 0; i < S; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                if (pos == A) {
                    pos = B;
                } 
                else if (pos == B) {
                    pos = A;
                }
            }

            System.out.println(pos);
        }

        sc.close();
    }
}
