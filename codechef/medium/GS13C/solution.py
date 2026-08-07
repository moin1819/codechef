import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            sb.append(N + 1).append("\n");
        }

        System.out.print(sb);
    }
}