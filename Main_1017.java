/*
1017 A除以B (20 分)
本题要求计算 A/B，其中 A 是不超过 1000 位的正整数，B 是 1 位正整数。你需要输出商数 Q 和余数 R，使得 A=B×Q+R 成立。

输入格式：
输入在一行中依次给出 A 和 B，中间以 1 空格分隔。

输出格式：
在一行中依次输出 Q 和 R，中间以 1 空格分隔。

输入样例：
123456789050987654321 7
输出样例：
17636684150141093474 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main (String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = bufferedReader.readLine().split(" ");bufferedReader.close();
        int b = Integer.parseInt(ab[1]);
        String a= ab[0];
        StringBuilder Q = new StringBuilder();
        int last = 0;
        for (int i = 0; i < a.length(); i++) {
            last = last * 10 + a.charAt(i) - '0';
            Q.append((char)(last / b + '0'));
            last = last % b;
        }
        boolean f = false;
        String res = Q.toString();
        for ( int j = 0 ; j < res.length() ; j++ ) {
            if ( f == false ) {
                if ( res.charAt(j) != '0' ) {
                    f = true;
                    System.out.print(res.charAt(j));
                }
            } else
                System.out.print(res.charAt(j));
        }
        if ( f == false )
            System.out.print("0");
        System.out.println(" "+last);
    }
}
