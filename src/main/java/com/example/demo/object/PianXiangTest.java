package com.example.demo.object;

import org.openjdk.jol.info.ClassLayout;

public class PianXiangTest {
    public static void main(String[] args) {
        Object lightObject = new Object();
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object biasedLockObject = new Object();


        System.out.println("---------------------------------------加锁前---------------------------------------");
        System.out.println("\n轻量级锁：" + ClassLayout.parseInstance(lightObject).toPrintable()
                + "偏向锁：" + ClassLayout.parseInstance(biasedLockObject).toPrintable());
        System.out.println("---------------------------------------加锁后---------------------------------------");
        synchronized (lightObject) {
            System.out.println("轻量级锁：" + ClassLayout.parseInstance(lightObject).toPrintable());
        }
        synchronized (biasedLockObject) {
            System.out.println("偏向锁：" + ClassLayout.parseInstance(biasedLockObject).toPrintable());
        }

        System.out.println("---------------------------------------释放锁---------------------------------------");
        System.out.println("\n轻量级锁：" + ClassLayout.parseInstance(lightObject).toPrintable()
        +"偏向锁：" + ClassLayout.parseInstance(biasedLockObject).toPrintable());
    }
}
