
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] L = new int[n];
            int[] G = new int[n];

            for (int i = 0; i < n; i++) {
                L[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                G[i] = sc.nextInt();
            }

            boolean front = true;
            boolean back = true;

            for (int i = 0; i < n; i++) {

                // Check front orientation
                if (L[i] > G[i]) {
                    front = false;
                }

                // Check back orientation
                if (L[i] > G[n - 1 - i]) {
                    back = false;
                }
            }

            if (front && back) {
                System.out.println("both");
            } 
            else if (front) {
                System.out.println("front");
            } 
            else if (back) {
                System.out.println("back");
            } 
            else {
                System.out.println("none");
            }
        }

        sc.close();
    }
}
