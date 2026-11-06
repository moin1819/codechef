
import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            if (s.contains("I")) {
                System.out.println("INDIAN");
            } 
            else if (s.contains("Y")) {
                System.out.println("NOT INDIAN");
            } 
            else {
                System.out.println("NOT SURE");
            }
        }

        sc.close();
    }
}
