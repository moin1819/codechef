
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            if (X >= Y) {
                System.out.println("PIZZA");
            } 
            else if (X >= Z) {
                System.out.println("BURGER");
            } 
            else {
                System.out.println("NOTHING");
            }
        }
    }
}
