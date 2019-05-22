/*
1013 数素数 （20 分)
令Pi表示第i个素数。现任给两个正整数 M≤N≤10^4，请输出PM到PN的所有素数。
输入格式：
输入在一行中给出 M 和 N，其间以空格分隔。

输出格式：
输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。

输入样例：
5 27
输出样例：
11 13 17 19 23 29 31 37 41 43
47 53 59 61 67 71 73 79 83 89
97 101 103
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        List<Integer> PrimeNumber = GetList(n);
        int count = 0;
        for (int i = m-1 ; i < n ; i++ ) {
            System.out.print(PrimeNumber.get(i));
            if ( count != 9 && i != n - 1)
                System.out.print(" ");
            count++;
            if ( count == 10 ) {
                System.out.println();
                count = 0;
            }
        }
    }
    public static List<Integer> GetList(int N) {
        List<Integer> PrimeNumber = new ArrayList<>();
        PrimeNumber.add(2);
        PrimeNumber.add(3);
        for ( int i = 4 ; PrimeNumber.size() <= N ; i++ ) {
            int tmp = (int)Math.sqrt((double)i);
            for ( int j = 2 ; j <= tmp ; j++ ) {
                if ( i % j == 0 )
                    break;
                if ( j == tmp )
                    PrimeNumber.add(i);
            }
        }
        return PrimeNumber;
    }
}