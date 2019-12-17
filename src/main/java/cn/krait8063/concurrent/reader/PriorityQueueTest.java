package cn.krait8063.concurrent.reader;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * created by krait8064 at 2019/12/16
 */
public class PriorityQueueTest {
    @Test
    public void test() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(2, Comparator.comparingInt(Integer::intValue));
        queue.add(3);
        queue.add(4);
        queue.add(1);
        Integer poll = queue.poll();
        Integer poll1 = queue.poll();
        Integer poll2 = queue.poll();
    }
}
