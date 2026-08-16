import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int N = sc.nextInt();
        while (N-- > 0) {
            String word = sc.next();
            boolean canRead = true;
            for (int i = 0; i < word.length(); i++) {
                if (S.indexOf(word.charAt(i)) == -1) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}