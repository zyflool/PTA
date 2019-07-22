/*
1020 月饼 (25 分)
月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。
现给定所有种类月饼的库存量、总售价、以及市场的最大需求量，请你计算可以获得的最大收益是多少。

注意：销售时允许取出一部分库存。
样例给出的情形是这样的：
假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、72、45亿元。
如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得72 + 45 / 2 = 94.5（亿元）。

输入格式：
每个输入包含一个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、以及不超过500（以万吨为单位）的正整数D表示市场最大需求量。
随后一行给出N个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿元为单位）。数字间以空格分隔。

输出格式：
对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。

输入样例：
3 20
18 15 10
75 72 45
输出样例：
94.50
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class MoonCake implements Comparable<MoonCake> {
        double inventory;
        double TotalPrice;
        double price;
        public MoonCake (double inventory, double TotalPrice, double price) {
            this.inventory = inventory;
            this.price = price;
            this.TotalPrice = TotalPrice;
        }
        @Override
        public int compareTo(MoonCake o) {
            return price > o.price ? -1 : 1;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int D = Integer.parseInt(in[1]);

        List<MoonCake> moonCakes = new ArrayList<>();
        String[] Inventory = br.readLine().split(" ");
        String[] Price =  br.readLine().split(" ");
        for ( int i = 0 ; i < N ; i++ ) {
            double inv = Double.parseDouble(Inventory[i]);
            double pri = Double.parseDouble(Price[i]);
            double tot = pri / inv;
            moonCakes.add( new MoonCake(inv, pri, tot) );
        }
        Collections.sort(moonCakes);

        double income = 0.0;
        for (int i = 0 ; i < N ; i++ ) {
            if (moonCakes.get(i).inventory <= D ) {
                income += moonCakes.get(i).TotalPrice;
                D -= moonCakes.get(i).inventory;
            } else {
                income += moonCakes.get(i).price * D;
                break;
            }
        }

        System.out.println(String.format("%.2f", income));
    }
}