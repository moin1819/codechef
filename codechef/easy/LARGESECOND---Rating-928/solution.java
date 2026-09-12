import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                if (x > largest) {
                    secondLargest = largest;
                    largest = x;
                } 
                else if (x > secondLargest && x != largest) {
                    secondLargest = x;
                }
            }

            System.out.println(largest + secondLargest);
        }

        sc.close();
    }
}