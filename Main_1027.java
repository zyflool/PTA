/*
1027 打印沙漏 (20 分)
本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
*****
 ***
  *
 ***
*****
所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。

输入格式:
输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。

输出格式:
首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。

输入样例:
19 *
输出样例:
*****
 ***
  *
 ***
*****
2
*/


/*
1  1                                 1
2  1+6                               7
3  1+6+10                            17
4  1+6+10+14                         31
5  1+6+10+14+18                      49
6  1+6+10+14+18+22                   71
7  1+6+10+14+18+22+26                97
8  1+6+10+14+18+22+26+30             127
9  1+6+10+14+18+22+26+30+34          161
10 1+6+10+14+18+22+26+30+34+38       199
11 1+6+10+14+18+22+26+30+34+38+42    241
12 1+6+10+14+18+22+26+30+34+38+42+46 287
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] count(int n) {
        int t = 1;
        int i = 1;
        while ( t <= n ) {
            t += ( 2 * i + 1 ) * 2;
            i++;
        }
        int[] result = new int[2];
        result[0] = i - 1;
        result[1] = t - ( 2 * ( i - 1 ) + 1 ) * 2;
        return result;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        String c = in[1];
        int[] res;
        res = count(n);
        //System.out.println("有 "+res[0]+" 行");
        //System.out.println("用了 "+res[1]+" 个");
        for (int i = res[0] ; i >= 1 ; i-- ) { //行数            [2]  3     2     1
            for (int j = 0 ; j < res[0] - 1; j++ ){ //左半行          2*    1空1*  2空0*
                if (j < res[0] - i )  //3-3=0 0  3-2=1 0  3-1=2
                    System.out.print(" ");
                else
                    System.out.print(c);
            }

            System.out.print(c);

            for (int j = res[0] - 2 ; j >= 0; j-- ){ //左半行          2*    1空1*  2空0*
                if (j >= res[0] - i )  //3-3=0 0  3-2=1 0  3-1=2
                    System.out.print(c);
                else break;
            }
            System.out.println();
        }
        for (int i = 1 ; i < res[0] ; i++ ) { //行数            [2]  1      2
            for (int j = 0 ; j < res[0] - 1; j++ ){ //左半行           1空1*   2*
                if (j < res[0] - i - 1 )            //
                    System.out.print(" ");
                else
                    System.out.print(c);
            }
            System.out.print(c);
            for (int j = res[0] - 1 ; j >= 0; j-- ){ //右半行
                if (j >= res[0] - i )  //
                    System.out.print(c);
                else break;
            }
            System.out.println("");
        }
        System.out.println(n-res[1]);
    }
}