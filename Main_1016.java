/*
1016 部分A+B (15 分)
正整数 A 的“DA（为 1 位整数）部分”定义为由 A 中所有 DA组成的新整数PA。例如：给定 A=3862767，DA=6，则 A 的“6 部分”PA是66，因为A中有2个6。
现给定A、DA、B、DB，请编写程序计算PA+PB。

输入格式：
输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0<A,B<10^10。

输出格式：
在一行中输出PA+PB的值。

输入样例 1：
3862767 6 13530293 3
输出样例 1：
399
输入样例 2：
3862767 1 13530293 8
输出样例 2：
0
 */

import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        String a, b;
        int da, db, pa = 0, pb = 0;
        a = in.next();
        da = in.nextInt();
        b = in.next();
        db = in.nextInt();
        int time = 1;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == (char) (da + '0')) {
                pa += da * time;
                time *= 10;
            }
        }
        time = 1;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == (char) (db + '0')) {
                pb += db * time;
                time *= 10;
            }
        }
        System.out.println(pa+pb);
    }