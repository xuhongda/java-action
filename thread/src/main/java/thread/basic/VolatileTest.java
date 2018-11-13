package thread.basic;

/**
 * <p>
 * 内存可见性问题
 * </p>
 *
 * @author xuhongda on 2018/8/16
 * thread.basic
 * javase-practice
 */
public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable thread = new MyRunnable();
        new Thread(thread).start();
        // Thread.sleep(10);
        while (true) {
            if (thread.isFlag()) {
                System.out.println("<><><><>");
                break;
            }
        }
    }
}

class MyRunnable implements Runnable {
    /**
     * volatile 关键字
     * 注意： volatile 不具备互斥性；不保证原子性
     */
    private volatile boolean flag = false;

    @Override
    public void run() {
        flag = true;
        System.out.println(flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}