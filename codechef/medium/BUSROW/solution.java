import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int N = sc.nextInt();
                int M = sc.nextInt();
                int X = sc.nextInt();
                
                int R = (X + M - 1) / M;
                int frontDistance = R;
                int backDistance = N - R + 1;
                
                System.out.println(Math.min(frontDistance, backDistance));
            }
        }
        sc.close();
    }
}