package thread.basic;

/**
 * @author xuhongda on 2018/8/16
 * thread.basic
 * javase-practice
 */
public class ExtendThread extends Thread {


    @Override
    public void run(){
        Ticket.func1();
        System.out.println("is run "+Thread.currentThread().getName());
    }
}
