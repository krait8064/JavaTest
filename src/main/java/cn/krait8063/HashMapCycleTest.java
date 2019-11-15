package cn.krait8063;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapCycleTest extends Thread {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2);
    static AtomicInteger at = new AtomicInteger();

    @Override
    public void run() {
        while (at.get() < 100000) {
            map.put(at.get(), at.get());
            at.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        HashMapCycleTest t1 = new HashMapCycleTest();
        HashMapCycleTest t2 = new HashMapCycleTest();
        HashMapCycleTest t3 = new HashMapCycleTest();
        HashMapCycleTest t4 = new HashMapCycleTest();
        HashMapCycleTest t5 = new HashMapCycleTest();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
