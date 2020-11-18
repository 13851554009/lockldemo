package com.example.demo.object;

import org.openjdk.jol.info.ClassLayout;

public class ObjectBigSmallTest {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("new Object:" + ClassLayout.parseInstance(o).toPrintable());
        A a = new A();
        System.out.println("new A:" + ClassLayout.parseInstance(a).toPrintable());
        a.setFlag(true);
        a.setI(1);
        a.setStr("ABC");
        System.out.println("赋值 A:" + ClassLayout.parseInstance(a).toPrintable());
    }
}
