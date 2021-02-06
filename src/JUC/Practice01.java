package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhangchen
 * @date: 2021/2/1
 * @description:
 */
class Sugar {

    /**
     * 一开始有0块糖
     */
    private int num = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int maxNum = 3;
    int minNum = 1;

    /**
     * 加糖
     */
    public void addSugar() {
        lock.lock();
        try {

            //如果比最大数量多，就等着，不然就加一个
            while (num > maxNum) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "正在运行" + "\t糖果数为" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /**
     * 减糖
     */
    public void dissSugar() {
        lock.lock();
        try {

            //如果比最大数量多，就等着，不然就加一个
            while (num < minNum) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "正在运行" + "\t糖果数为" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}


/**
 * @author zhangchen
 */
public class Practice01 {
    public static void main(String[] args) {

        Sugar sugar = new Sugar();


        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                sugar.addSugar();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                sugar.addSugar();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                sugar.dissSugar();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                sugar.dissSugar();
            }
        }, "D").start();

    }


}
