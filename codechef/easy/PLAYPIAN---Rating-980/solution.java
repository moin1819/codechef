import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            boolean valid = true;

            // Check every pair
            for (int i = 0; i < s.length(); i += 2) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }
}