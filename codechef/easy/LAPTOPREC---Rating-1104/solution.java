
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int[] count = new int[11];

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                count[x]++;
            }

            int max = 0;
            int laptop = 0;
            int frequency = 0;

            for (int i = 1; i <= 10; i++) {
                if (count[i] > max) {
                    max = count[i];
                    laptop = i;
                    frequency = 1;
                } else if (count[i] == max) {
                    frequency++;
                }
            }

            if (frequency == 1) {
                System.out.println(laptop);
            } else {
                System.out.println("CONFUSED");
            }
        }

        sc.close();
    }
}
