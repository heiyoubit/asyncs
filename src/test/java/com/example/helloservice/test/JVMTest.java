package com.example.helloservice.test;

import org.openjdk.jol.info.ClassLayout;

public class JVMTest {
    public static void main(String[] args) throws Exception {
        A a = new A();
        B b = new B();
        System.out.println("------After Initialization------\n" + ClassLayout.parseInstance(a).toPrintable() + "\n" + ClassLayout.parseInstance(b).toPrintable());

        System.out.println("a.hashcode: " + a.hashCode());
        System.out.println("b.hashcode: " + b.hashCode());
        System.out.println("------After call hashcode------\n" + ClassLayout.parseInstance(a).toPrintable() + "\n" + ClassLayout.parseInstance(b).toPrintable());
    }

    //A没有覆盖默认的 hashcode 方法
    static class A {
        long d;
    }
    //B覆盖了 hashcode 方法
    static class B {
        long d;

        @Override
        public int hashCode() {
            return (int) 5555;
        }
    }
}
