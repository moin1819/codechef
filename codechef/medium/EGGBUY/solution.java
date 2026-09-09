import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int F = sc.nextInt();
        
        int cost1 = 12 * X;
        int cost2 = 12 * Y + F;
        
        System.out.println(Math.min(cost1, cost2));
    }
}