import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            while (t-- > 0) {
                String s = sc.next();
                
                // Get the first two digits and second two digits
                int a = Integer.parseInt(s.substring(0, 2));
                int b = Integer.parseInt(s.substring(3, 5));
                
                // Months can only go up to 12
                if (a > 12) {
                    System.out.println("DD/MM/YYYY");
                } else if (b > 12) {
                    System.out.println("MM/DD/YYYY");
                } else {
                    System.out.println("BOTH");
                }
            }
        }
        
        sc.close();
    }
}