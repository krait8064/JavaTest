package cn.krait8063.concurrent.reader.multi.thread;

/**
 * created by krait8064 at 2019/11/18
 */
public class SynPrintTest {
    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) { // 先获取 prev 锁
                    synchronized (self) {// 再获取 self 锁
                        System.out.print(name);//打印
                        count--;

                        self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                    }
                    //此时执行完self的同步块，这时self锁才释放。
                    try {
                        if (count == 0) {
                            prev.notifyAll();
                        } else
                            prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        /**
                         * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                         */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", a, b);
        ThreadPrinter pb = new ThreadPrinter("B", b, c);
        ThreadPrinter pc = new ThreadPrinter("C", c, a);

        new Thread(pa).start();
        Thread.sleep(10);//保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}
