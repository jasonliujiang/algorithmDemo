package product_consume;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过ReentrantLock实现简单生产者消费者模型
 */
public class Reentrant_p_c {
    private int number = 0;
    private final int MAX = 10;
    private final int MIN = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Reentrant_p_c pc = new Reentrant_p_c();
        Cunsumer cunsumer = pc.new Cunsumer();
        Producer producer = pc.new Producer();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0;i<20;i++){
            service.execute(producer);
        }

        for (int i = 0; i < 20; i++) {
            service.execute(cunsumer);
        }
        String s = "1234";
        System.out.println(s.contains("12"));


    }

    class Producer extends Thread{
        @Override
        public void run() {
            try {
                //加锁
                lock.lock();
                while (number>=MAX){
                    System.out.println("生产已满");
                    condition.await();
                }
                number++;
                System.out.println("生产了第"+number+"个产品");

                condition.signalAll();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    class Cunsumer extends Thread{
        @Override
        public void run() {
            try {
                //加锁
                lock.lock();
                while (number<=MIN){
                    System.out.println("消费已空");
                    condition.await();
                }
                number--;
                System.out.println("消费了第"+number+"个产品");

                condition.signalAll();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
