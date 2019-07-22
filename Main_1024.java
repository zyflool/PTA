/*
1024 科学计数法 (20 分)
科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，
其满足正则表达式 [+-][1-9].[0-9]+E[+-][0-9]+，
即数字的整数部分只有 1 位，小数部分至少有 1 位，该数字及其指数部分的正负号即使对正数也必定明确给出。

现以科学计数法的格式给出实数 A，请编写程序按普通数字表示法输出 A，并保证所有有效位都被保留。

输入格式：
每个输入包含 1 个测试用例，即一个以科学计数法表示的实数 A。该数字的存储长度不超过 9999 字节，且其指数的绝对值不超过 9999。

输出格式：
对每个测试用例，在一行中按普通数字表示法输出 A，并保证所有有效位都被保留，包括末尾的 0。

输入样例 1：
+1.23400E-03
输出样例 1：
0.00123400
输入样例 2：
-1.2E+10
输出样例 2：
-12000000000
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split("E");

        int time = Integer.parseInt(in[1]);
        //System.out.println("time = "+time);

        boolean sign;
        if (in[0].charAt(0) == '-' )
            sign = false;
        else sign = true;

        /*System.out.print("sign = ");
        if ( sign == false )
            System.out.println("-");
        else System.out.println("+");
        */

        String[] num = in[0].split("\\.");

        int n1 = Integer.parseInt(num[0]);
        if ( sign == false )
            n1 = 0 - n1;
        //System.out.println("n1 = "+n1);

        if( time == 0 ) {

            System.out.println(in[0] + "" + in[1]);

        } else {
            if ( sign == false ) System.out.print("-");

            if ( time > 0 ) {

                int l = num[1].length();
                //System.out.println("num[2].length = "+l);

                if ( l >= time ) {
                    System.out.print(n1);
                    for (int i = 0; i < time; i++)
                        System.out.print(num[1].charAt(i));
                    if ( l != time )
                        System.out.print(".");
                    while ( l != time ) {
                        System.out.print(num[1].charAt(time));
                        time++;
                    }
                } else {
                    System.out.print(n1);

                    for (int i = 0; i < l; i++)
                        System.out.print(num[1].charAt(i));

                    for ( int i = 0 ; i < time - l ; i++ )
                        System.out.print("0");

                }

            } else if ( time < 0 ) {

                System.out.print("0.");
                for (int i = 1 ; i < ( 0 - time ) ; i++ )
                    System.out.print("0");
                System.out.print(n1+num[1]);

            }
        }
    }
}