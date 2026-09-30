import java.util.Scanner;

public class Main {
    public static void solve(Scanner sc) {
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();

        // Check all 3 possible combinations for (checked-in bags, carry-on bag)
        if ((A + B <= D && C <= E) || 
            (A + C <= D && B <= E) || 
            (B + C <= D && A <= E)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }
}