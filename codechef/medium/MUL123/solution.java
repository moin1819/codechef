import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int N = sc.nextInt();
                if (N % 3 == 0) {
                    System.out.println(0);
                } else {
                    int nextMult5 = N + (5 - (N % 5));
                    if ((N + 1) % 3 == 0 || nextMult5 % 3 == 0) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                }
            }
        }
        sc.close();
    }
}