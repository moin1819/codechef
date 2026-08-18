import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int t = scanner.nextInt();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            
            int consecutiveConsonants = 0;
            boolean isEasy = true;
            
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                
                if (vowels.contains(ch)) {
                    consecutiveConsonants = 0; // Reset count on encountering a vowel
                } else {
                    consecutiveConsonants++;
                    if (consecutiveConsonants == 4) {
                        isEasy = false;
                        break;
                    }
                }
            }
            
            if (isEasy) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}