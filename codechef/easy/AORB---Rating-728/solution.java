import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        // Helper method to parse input quickly
        if (!st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return;
            st = new StringTokenizer(line);
        }

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            // Order A -> B
            int order1 = (500 - 2 * X) + (1000 - 4 * (X + Y));

            // Order B -> A
            int order2 = (1000 - 4 * Y) + (500 - 2 * (X + Y));

            sb.append(Math.max(order1, order2)).append("\n");
        }

        System.out.print(sb);
    }
}