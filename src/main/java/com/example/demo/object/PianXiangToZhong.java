package com.example.demo.object;

import org.openjdk.jol.info.ClassLayout;

public class PianXiangToZhong {
    static Object object = null;

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("线程0");
        Thread.sleep(6000);
        object = new Object();
        System.out.print("初始偏向锁->" + "线程名称：" + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(object).toPrintable());
        sysn("线程1");
        Thread.sleep(1000);
        System.out.print("线程1占用,未有其他线程尝试获取锁->" + "线程名称：" + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(object).toPrintable());
        sysn("线程2");
        Thread.sleep(1000);
        System.out.print("线程1占用，线程2尝试获取锁后->" + "线程名称：" + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(object).toPrintable());
        Thread.sleep(10000);
        System.out.println("释放锁->" + "线程名称：" + Thread.currentThread().getName() + ClassLayout.parseInstance(object).toPrintable());
    }

    private static void sysn(String threadName) {
        new Thread(() -> {
            Thread.currentThread().setName(threadName);
            synchronized (object) {
                System.out.print(threadName + "占用中->" + "线程名称：" + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(object).toPrintable());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
