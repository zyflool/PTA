/*
1019 数字黑洞 (20 分)
给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，将得到一个新的数字。
一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫 Kaprekar 常数。
例如，我们从6767开始，将得到
7766 - 6677 = 1089
9810 - 0189 = 9621
9621 - 1269 = 8352
8532 - 2358 = 6174
7641 - 1467 = 6174
... ...
现给定任意4位正整数，请编写程序演示到达黑洞的过程。

输入格式：
输入给出一个(0,10^4) 区间内的正整数 N。

输出格式：
如果N的4位数字全相等，则在一行内输出N - N = 0000；
否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例。注意每个数字按4位数格式输出。

输入样例 1：
6767
输出样例 1：
7766 - 6677 = 1089
9810 - 0189 = 9621
9621 - 1269 = 8352
8532 - 2358 = 6174
输入样例 2：
2222
输出样例 2：
2222 - 2222 = 0000
*/
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        while ( true ) {
            char[] s = String.format("%04d",n).toCharArray();
            Arrays.sort(s);
            int a1 = 0;
            for (int i = 3; i >= 0; i--)
                a1 = a1 * 10 + (s[i] - '0');
            int a2 = 0;
            for (int i = 0; i <= 3; i++)
                a2 = a2 * 10 + (s[i] - '0');
            n = a1 - a2;
            if ( n == 0 ) {
                System.out.printf("%04d - %04d = %04d\n",a1,a2,n);
                break;
            }
            if ( n == 6174) {
                System.out.printf("%04d - %04d = %04d\n",a1,a2,n);
                break;
            }
            System.out.printf("%04d - %04d = %04d\n",a1,a2,n);
        }
    }
}