/*
1022 D进制的A+B (20 分)
输入两个非负 10 进制整数 A 和 B (≤ 2^30 − 1)，输出 A+B 的 D (1<D≤10)进制数。

输入格式：
输入在一行中依次给出 3 个整数 A、B 和 D。

输出格式：
输出 A+B 的 D 进制数。

输入样例：
123 456 8
输出样例：
1103
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);
        int d = Integer.parseInt(in[2]);
        a += b;
        ArrayList<Integer> n = new ArrayList<>();
        if( a == 0 )
            n.add(0);
        while ( a > 0 ) {
            n.add(0,a % d );
            a /= d;
        }
        for ( int i = 0 ; i < n.size() ; i++ )
            System.out.print(n.get(i));
    }
}