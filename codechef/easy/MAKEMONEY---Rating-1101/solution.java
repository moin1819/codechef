import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long x = scanner.nextLong();
            long c = scanner.nextLong();
            long totalSum = 0;
            for (int i = 0; i < n; i++) {
                long a = scanner.nextLong();
                if (x - c > a) {
                    totalSum += (x - c);
                } else {
                    totalSum += a;
                }
            }
            System.out.println(totalSum);
        }
        scanner.close();
    }
}