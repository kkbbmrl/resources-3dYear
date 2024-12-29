package TPsSE;

import java.util.Scanner;

/**
 *
 * @author Belhadj Foudil
 */
public class TP1_1 {
    
    // the mono thread version of the 

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.err.println("Give your First number a ");
        int a = scanner.nextInt();
        
        System.err.println("Give your Scond number b ");
        int b = scanner.nextInt();
        
        int res = sum(a,b);
        
        System.out.println("The Sum from "  + a + " to " + b + " is : " + res);
        
        
    }

    static  public int sum(int a, int b) {
        int s = 0;

        for (int i = a; i <= b; i++) {
            s += i;
        }

        return s;
    }

}
