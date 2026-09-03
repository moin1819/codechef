import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            
            int minDiff = 0;
            int maxDiff = 0;
            
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                
                if (c1 != '?' && c2 != '?' && c1 != c2) {
                    minDiff++;
                }
                
                if (c1 == '?' || c2 == '?' || c1 != c2) {
                    maxDiff++;
                }
            }
            
            System.out.println(minDiff + " " + maxDiff);
        }
        sc.close();
    }
}