/*
换个格式输出整数 （15 分）
我们让字母用B来表示“百”，字母S表示“十”，用12...n来表示不为零的个位数字n（< 1 0），例如234应该被输出为BBSSS1234，因为它有2个“百”，3个“十”，以及个位的4。

输入格式：
每个测试输入包含1个测试用例，给出正整数 n（< 1 0 0 0）。

输出格式：
每个测试用例的输出占一行，用规定的格式输出 n。

输入样例1：
234
输出样例1：
BBSSS1234
输入样例2：
23
输出样例2：
SS123
 */
import java.util.Scanner;

public class Main
{
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if ( n/100 >= 1 )
            B(n / 100 );
        if ( n / 10 >= 1 )
            S(n%100/10 );
        if ( n >= 1 )
            N(n%100%10 );
    }

    public static void B ( int x ) {
        for (int i = 1 ; i <= x ; i ++)
            System.out.print("B");
    }

    public static void S ( int y ) {
        for (int i = 1 ; i <= y ; i++ )
            System.out.print("S");
    }

    public static void N(int z) {
        for (int i = 1 ; i <= z ; i++ )
            System.out.print(i);
    }
}
