
import java.util.Scanner;

class Main {

    static int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int sumN = digitSum(n);
            int x = n + 1;

            while (true) {
                int sumX = digitSum(x);

                if (sumN % 2 != sumX % 2) {
                    System.out.println(x);
                    break;
                }

                x++;
            }
        }

        sc.close();
    }
}
