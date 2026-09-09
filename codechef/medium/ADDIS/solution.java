import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            HashMap<Integer, Integer> freq = new HashMap<>();

            int maxFreq = 0;

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                int count = freq.getOrDefault(x, 0) + 1;
                freq.put(x, count);

                maxFreq = Math.max(maxFreq, count);
            }

            System.out.println((maxFreq + 1) / 2);
        }

        sc.close();
    }
}