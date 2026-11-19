import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            int K = sc.nextInt();
            
            int uncleJohnyLength = A[K - 1];
            int position = 1;
            
            for (int length : A) {
                if (length < uncleJohnyLength) {
                    position++;
                }
            }
            
            System.out.println(position);
        }
        sc.close();
    }
}