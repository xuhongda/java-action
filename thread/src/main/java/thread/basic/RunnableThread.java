package thread.basic;

/**
 * @author xuhongda on 2018/8/16
 * thread.basic
 * javase-practice
 */
public class RunnableThread implements Runnable {

    @Override
    public  void run() {
        System.out.println("is runnable "+Thread.currentThread().getName());
    }
}
