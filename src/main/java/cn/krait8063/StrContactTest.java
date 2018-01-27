package cn.krait8063;

public class StrContactTest {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s4 == s3);
        s4 = (s1 + s2).intern();
        System.out.println(s4 == s3);
    }
}
