/*
1011 A+B 和 C （15 分)
给定区间 [−2^31,2^31] 内的 3 个整数 A、B 和 C，请判断 A+B 是否大于 C。

输入格式：
输入第 1 行给出正整数 T (≤10)，是测试用例的个数。随后给出 T 组测试用例，每组占一行，顺序给出 A、B 和 C。整数间以空格分隔。

输出格式：
对每组测试用例，在一行中输出 Case #X: true 如果 A+B>C，否则输出 Case #X: false，其中 X 是测试用例的编号（从 1 开始）。

输入样例：
4
1 2 3
2 3 4
2147483647 0 2147483646
0 -2147483648 -2147483647
输出样例：
Case #1: false
Case #2: true
Case #3: true
Case #4: false
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Boolean> res = new ArrayList<>();
        int t = in.nextInt();
        for (int i = 1 ; i <= t ; i++ ) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            //System.out.println(a+" "+b+" "+c);
            if ( a == 0 ) {
                if ( b == 0 ) {
                    if ( c == 0 ) { // 0 0 0
                        res.add(false);
                    } else if ( c > 0 ) { //0 0 +
                        res.add(false);
                    } else if ( c < 0 ) { // 0 0 -
                        res.add(true);
                    }
                } else if ( b > 0 ) {
                    if ( c == 0 ) { // 0 + 0
                        res.add(true);
                    } else if ( c > 0 ) { // 0 + +
                        if ( b > c )
                            res.add(true);
                        else
                            res.add(false);
                    } else if ( c < 0 ) { // 0 + -
                        res.add(true);
                    }
                } else if ( b < 0 ) {
                    if ( c == 0 ) { // 0 - 0
                        res.add(false);
                    } else if ( c > 0 ) {// 0 - +
                        res.add(false);
                    } else if ( c < 0 ) { //0 - -
                        if ( b > c )
                            res.add(true);
                        else
                            res.add(false);
                    }
                }
            } else if ( a > 0 ) {
                if ( b == 0 ) {
                    if ( c == 0 ) { // + 0 0
                        res.add(true);
                    } else if ( c > 0 ) { // + 0 +
                        if ( a > c )
                            res.add(true);
                        else
                            res.add(false);
                    } else if ( c < 0 ) { // + 0 -
                        res.add(true);
                    }
                } else if ( b > 0 ) {
                    if ( c == 0 ) { // + + 0
                        res.add(true);
                    } else if ( c > 0 ) {  // + + +
                        long tmp = c - a;
                        if ( b > tmp )
                            res.add(true);
                        else
                            res.add(false);
                    } else if ( c < 0 ) { // + + -
                        res.add(true);
                    }
                } else if ( b < 0 ) {
                    if ( c == 0 ) {  // + - 0
                        if ( a + b > c )
                            res.add(true);
                        else
                            res.add(false);
                    } else if ( c > 0 ) { // + - +
                        if ( a + b > c )
                            res.add(true);
                        else
                            res.add(false);
                    } else if ( c < 0 ) { // + - -
                        if ( a + b > c )
                            res.add(true);
                        else
                            res.add(false);
                    }
                }
            } else if ( a < 0 ) {
                if ( b == 0 ) {
                    if ( c == 0 ) { // - 0 0
                        res.add(false);
                    } else if ( c > 0 ) { // - 0 +
                        res.add(false);
                    } else if ( c < 0 ) { // - 0 -
                        if ( a > c )
                            res.add(true);
                        else
                            res.add(false);
                    }
                } else if ( b > 0 ) {
                    if ( c == 0 ) { // - + 0
                        if ( a + b > c )
                            res.add(true);
                        else
                            res.add(false);
                    } else if ( c > 0 ) { // - + +
                        if ( a + b > c )
                            res.add(true);
                        else
                            res.add(false);
                    } else if ( c < 0 ) { // - + -
                        if ( a + b > c )
                            res.add(true);
                        else
                            res.add(false);
                    }
                } else if ( b < 0 ) {
                    if ( c == 0 ) { // - - 0
                        res.add(false);
                    } else if ( c > 0 ) { // - - +
                        res.add(false);
                    } else if ( c < 0 ) { // - - -
                        long tmp = c - a;
                        if ( b > tmp )
                            res.add(true);
                        else
                            res.add(false);
                    }
                }
            }
        }
        for ( int i = 0 ; i < res.size() ; i++ ) {
            System.out.print("Case #" + (i+1) + ": " + res.get(i));
            if ( i != res.size() - 1 )
                System.out.println();
        }
    }
}
