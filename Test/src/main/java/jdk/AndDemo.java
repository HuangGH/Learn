package jdk;

/**
 * @author hgh
 * @since 2020-03-25 13:41
 */
public class AndDemo {
    public static void main(String[] args) {

        // 5 ->0 1 0 1
        // 4 ->  1 0 0
        //   ->  1 0 1
        // 1 符号位不变，按位取反  -> 0 1 1 1 1 0 1 0
        // 2.符号位为0（整数）：取反的结果-1，符号位为1（负数），取反结果+1   0 1 1 1 1 0 0 1
        // 3.包含符号位，按位取反  1 0 0 0 0 1 1 0
        // ~ -
        int a = 5 | 4; // 5
        int b = 5 & 4; // 4

        int c = ~5; // 2
        int d = ~-7; //  1 0 0 0 0 1 1 1
        //  1 1 1 1 1 0 0 0
        //  1 1 1 1 1 0 0 1
        //  0 0 0 0 0 1 1 0
        //  d == 6;

        int e = 2 ^ 3;// 1 0
        //  1 1
        //  异或

        // 1、<<:左移	左边最高位丢弃，右边补齐0;
        int f = 1 << 4;  // 0 0 0 1 0 0 0 0;
        int g = 32 >> 2;  // 0 0 1 0 0 0 0 0;
        // 01 0 0 0 0 1 0 0;

        //  右移的规则只记住一点：符号位不变，左边补上符号位 。
        int h = -16 >> 2;  // 0 0 0 0 1 0 0 0 0
        int j = 32 >> 2;  // 1 0 0 0 1 0 0 0
        int l = 1 >> 2;  // 0 0 0 0 0 0 0 1
        int M = 32 >>> 52;  // 0 0 0 0 0 0 0 1


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(j);
        System.out.println(l);
        System.out.println(M);


    }
}
