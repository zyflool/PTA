/*
1018 锤子剪刀布 (20 分)
大家应该都会玩“锤子剪刀布”的游戏：两人同时给出手势，胜负规则如图所示：
现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。

输入格式：
输入第 1 行给出正整数 N（≤10^5），即双方交锋的次数。随后 N 行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。
C 代表“锤子”、J 代表“剪刀”、B 代表“布”，第 1 个字母代表甲方，第 2 个代表乙方，中间有 1 个空格。

输出格式：
输出第 1、2 行分别给出甲、乙的胜、平、负次数，数字间以 1 个空格分隔。
第 3 行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有 1 个空格。如果解不唯一，则输出按字母序最小的解。

输入样例：
10
C J
J B
C B
B B
B C
C C
C B
J B
B C
J J
输出样例：
5 3 2
2 3 5
B B
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main (String args[]) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.valueOf(bufferedReader.readLine());
      int a1 = 0, a2 = 0, a3 = 0;
      int b1 = 0, b2 = 0, b3 = 0;
      int a[] = {0, 0, 0};
      int b[] = {0, 0, 0};
      for (int i = 0; i < n; i++) {
          char[] ab = bufferedReader.readLine().toCharArray();
          //String[] ab = bufferedReader.readLine().split(" "); 这个更慢
          if ( ab[0] == 'C' ) {
              if ( ab[2] == 'C' ) {
                  a3++;
                  b3++;
              } else if ( ab[2] == 'J' ) {
                  a[1]++;
                  a1++;
                  b2++;
              } else if ( ab[2] == 'B' ) {
                  b[0]++;
                  a2++;
                  b1++;
              }
          } else if (ab[0] == 'J') {
              if ( ab[2] == 'C' ) {
                  b[1]++;
                  a2++;
                  b1++;
              } else if ( ab[2] == 'J') {
                  a3++;
                  b3++;
              } else if ( ab[2] == 'B') {
                  a[2]++;
                  a1++;
                  b2++;
              }
          } else if (ab[0] == 'B') {
              if ( ab[2] == 'C' ) {
                  a[0]++;
                  a1++;
                  b2++;
              } else if ( ab[2] == 'J' ) {
                  b[2]++;
                  a2++;
                  b1++;
              } else if ( ab[2] == 'B' ) {
                  a3++;
                  b3++;
              }
          }
      }
      bufferedReader.close();
      System.out.println(a1 + " " + a3 + " " + a2);
      System.out.println(b1 + " " + b3 + " " + b2);
      int Jmax = a[0];
      char Jans = 'B';
      if(Jmax < a[1]) {
          Jmax = a[1];
          Jans = 'C';
      }
      if(Jmax < a[2]) {
          Jans = 'J';
      }
      System.out.print(Jans + " ");
      int Ymax = b[0];
      char Yans = 'B';
      if(Ymax < b[1]) {
          Ymax = b[1];
          Yans = 'C';
      }
      if(Ymax < b[2]) {
          Yans = 'J';
      }
      System.out.print(Yans);
  }
}
