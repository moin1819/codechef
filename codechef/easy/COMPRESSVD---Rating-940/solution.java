import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            // Read N
            while (st == null || !st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            int N = Integer.parseInt(st.nextToken());

            // Read the array of frames
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    line = br.readLine();
                    if (line == null) break;
                    st = new StringTokenizer(line);
                }
                A[i] = Integer.parseInt(st.nextToken());
            }

            // Count the minimum frames
            int count = 0;
            if (N > 0) {
                count = 1;
                for (int i = 1; i < N; i++) {
                    if (A[i] != A[i - 1]) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }
}