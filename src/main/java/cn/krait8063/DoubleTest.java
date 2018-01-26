package cn.krait8063;

import java.util.Stack;

public class DoubleTest {
    public static void main(String[] args) {
        //浮点数经度不足
        System.out.println(2.0 - 1.1);
        //负数求余，不等。因为负数整除之后结果为-x，与值符号相反
        System.out.println((-1 % 2) == 1);
    }
}
