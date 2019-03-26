/*
1007 素数对猜想 （20 分)
让我们定义dn为：dn=pn+1−pn，其中pi是第i个素数。显然有d1=1，且对于n>1有dn是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
现给定任意正整数N(<10^5)，请计算不超过N的满足猜想的素数对的个数。

输入格式:
输入在一行给出正整数N。

输出格式:
在一行中输出不超过N的满足猜想的素数对的个数。

输入样例:
20
输出样例:
4
 */
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main ( String args[] ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int now = 3;
        for ( int i = 4 ; i <= n ; i++ ) {
            if ( IfPrime(i) == true ) {
                if ( i - now == 2)
                    count++;
                now = i;
            }
        }
        System.out.println(count);
    }

    static boolean IfPrime (int m) {
        if ( m ==2  || m == 3 )
            return true;
        int z = (int)Math.sqrt((double)m);
        for ( int i = 2; i <= z ; i++ ) {
            if (m % i == 0)
                return false;
        }
        return true;
    }
}

/*
20
2 3 5 7 11 13 17 19
 1 2 2 4  2  4  2
 */
