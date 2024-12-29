package TPsSE;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TPHello {

    static Semaphore SH, SE, SL, SO;

    public static class PH extends Thread {

        @Override
        public void run() {
            
            int i=0;
            while (i <1000) {
                try {
                    SH.acquire();
                    System.out.print("H");
                    SE.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TPHello.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static class PE extends Thread {

        @Override
        public void run() {
            int i=0;
            while (i <1000) {
                try {
                    SE.acquire();
                    System.out.print("E");
                    SL.release();
                    SL.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TPHello.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static class PL extends Thread {

        @Override
        public void run() {
            int i=0;
            while (i <1000) {
                try {
                    SL.acquire();
                    System.out.print("L");
                    SO.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TPHello.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static class PO extends Thread {

        @Override
        public void run() {
            int i=0;
            while (i <1000) {
                try {
                    SO.acquire();
                    SO.acquire();
                    System.out.println("O");
                    SH.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TPHello.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        SH = new Semaphore(1);
        SE = new Semaphore(0);
        SL = new Semaphore(0);
        SO = new Semaphore(0);

        PH ph = new PH();
        PE pe = new PE();
        PL pl = new PL();
        PO po = new PO();

        po.start();
        pl.start();
        pe.start();
        ph.start();
    }
}
