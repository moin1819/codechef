import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            
            int countA = 0;
            int countB = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a') {
                    countA++;
                } else {
                    countB++;
                }
            }
            
            System.out.println(Math.min(countA, countB));
        }
        sc.close();
    }
}