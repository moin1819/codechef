import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        HashMap<String, Integer> map = new HashMap<>();

        // Count every adjacent pair
        for (int i = 0; i < s.length() - 1; i++) {
            String pair = s.substring(i, i + 2);
            map.put(pair, map.getOrDefault(pair, 0) + 1);
        }

        // Count distinct pairs appearing more than once
        int ans = 0;

        for (int count : map.values()) {
            if (count > 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}