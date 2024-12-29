package TPsSE;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class TP1_2 {
    
    // the main thread creates a second thread to make the sum

    public static class thread_sum extends Thread {

        String thread_name;
        int a, b, res;

        public thread_sum(String name, int a, int b) {
            this.thread_name = name;    // to make differene between multiple created threads
            this.a = a;
            this.b = b;
        }

        public int sum(int a, int b) {      
            int s = 0;

            for (int i = a; i <= b; i++) {
                s += i;
            }

            return s;
        }

        @Override
        public void run() {
            res = sum(a, b);
        }

        public String getResult() {     
            return "result of " + this.thread_name + " = " + res;
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

                
        Scanner scanner = new Scanner(System.in);
        System.err.println("Give your First number a ");
        int a = scanner.nextInt();
        
        System.err.println("Give your Scond number b ");
        int b = scanner.nextInt();

        
        thread_sum T1 = new thread_sum("T1", a, b);

        T1.start();

        Thread.sleep(2000); // wait for thread to terminate its execution
        System.out.println(T1.getResult());
    }

}
