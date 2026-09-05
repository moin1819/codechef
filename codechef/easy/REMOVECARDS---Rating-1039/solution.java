import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        while (T-- > 0) {
            // Read N
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int N = Integer.parseInt(st.nextToken());
            
            // Frequency array for numbers 1 to 10
            int[] freq = new int[11];
            int maxFreq = 0;
            
            // Read array elements
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                freq[num]++;
                maxFreq = Math.max(maxFreq, freq[num]);
            }
            
            System.out.println(N - maxFreq);
        }
    }
}