/*
1012 数字分类 （20 分)
给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
A1=能被5整除的数字中所有偶数的和；
A2=将被5除后余1的数字按给出顺序进行交错求和，即计算 n1−n2+n3−n4⋯；
A3=被5除后余2的数字的个数；
A4=被5除后余3的数字的平均数，精确到小数点后1位；
A5=被5除后余4的数字中最大数字。
输入格式：
每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。

输出格式：
对给定的 N 个正整数，按题目要求计算 A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。若其中某一类数字不存在，则在相应位置输出 N。

输入样例 1：
13 1 2 3 4 5 6 7 8 9 10 20 16 18
输出样例 1：
30 11 2 9.7 9

输入样例 2：
8 1 2 4 5 6 7 9 16
输出样例 2：
N 11 2 N 9
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int n;
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        int A4 = 0;
        int A5 = 0;
        int time = 1;
        int count = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        while ( N-- != 0) {
            n = in.nextInt();
            if ( n % 5 == 0 && n % 2 == 0 ) {
                A1 += n;
                flag1 = true;
            }
            if ( n % 5 == 1 ) {
                flag2 = true;
                A2 += n * time;
                time *= -1;
            }
            if ( n % 5 == 2 ) {
                A3++;
                flag3 = true;
            }
            if ( n % 5 == 3 ) {
                A4 += n;
                count++;
                flag4 = true;
            }
            if ( n % 5 == 4 &&  n > A5 ) {
                A5 = n;
                flag5 = true;
            }
        }
        if ( flag1 )
            System.out.print(A1+" ");
        else
            System.out.print("N ");
        if ( flag2 )
            System.out.print(A2+" ");
        else
            System.out.print("N ");
        if ( flag3 )
            System.out.print(A3+" ");
        else
            System.out.print("N ");
        if ( flag4 ) {
            System.out.printf("%.1f" + " ", A4 * 1.0 / count );
        } else
            System.out.print("N ");
        if ( flag5 )
            System.out.print(A5);
        else
            System.out.print("N");
    }
}