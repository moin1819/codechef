import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String tLine = reader.readLine();
        if (tLine == null) return;
        int T = Integer.parseInt(tLine.trim());
        
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine().trim());
            String S = reader.readLine().trim();

            int[] freq = new int[26];
            for (int i = 0; i < N; i++) {
                freq[S.charAt(i) - 'a']++;
            }

            boolean possible = true;
            for (int count : freq) {
                if (count % 2 != 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
}