import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String A = br.readLine();

            int ones = 0;

            // Count number of 1s in A
            for (char ch : A.toCharArray()) {
                if (ch == '1') {
                    ones++;
                }
            }

            int total = ones * M;

            // Total number of 1s is odd
            if (total % 2 != 0) {
                System.out.println(0);
                continue;
            }

            int target = total / 2;

            // freq[k] = number of positions in A
            // where prefix sum of 1s is k
            int[] freq = new int[ones + 1];

            int prefix = 0;

            for (int i = 0; i < N; i++) {
                if (A.charAt(i) == '1') {
                    prefix++;
                }

                freq[prefix]++;
            }

            long answer = 0;

            // For each copy of A
            for (int copy = 0; copy < M; copy++) {
                int required = target - copy * ones;

                if (required >= 0 && required <= ones) {
                    answer += freq[required];
                }
            }

            System.out.println(answer);
        }
    }
}