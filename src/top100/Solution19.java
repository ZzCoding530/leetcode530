package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/5
 * @description: 手写单例模式吧，有九种方式，一般应该要求是线程安全的，CAS锁的方式实在是有点累不想写那个
 * 就写双重校验+volatile方式的吧
 */

public class Solution19 {

    public static Solution19 instance;

    public Solution19() {
        System.out.println("对象被创建啦！");
    }

    public static Solution19 getInstance() {
        if (instance == null) {
            synchronized (Solution19.class) {
                if (instance == null) {
                    instance = new Solution19();
                }
            }
        }

        return instance;
    }


    public static void main(String[] args) {
        Solution19 instance1 = getInstance();
        Solution19 instance2 = getInstance();
        System.out.println(instance1 == instance2);
    }
}
