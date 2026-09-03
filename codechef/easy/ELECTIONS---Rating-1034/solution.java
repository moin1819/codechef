import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
       
        while(t-- > 0){
            int xa = sc.nextInt();
            int xb = sc.nextInt();
            int xc = sc.nextInt();
            
            if(xa > 50){
                System.out.println("A");
            } else if(xb > 50){
                System.out.println("B");
            } else if(xc > 50){
                System.out.println("C");
            } else {
                System.out.println("NOTA");
            }
        }
        sc.close();
	}
}