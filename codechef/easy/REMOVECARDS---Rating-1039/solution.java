import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] freq = new int[11];
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                freq[x]++;
        }
            int maxFreq = 0;
            for (int i = 1; i <= 10; i++) {
                maxFreq = Math.max(maxFreq, freq[i]);
    }
            System.out.println(N - maxFreq); 
        }
    }
}