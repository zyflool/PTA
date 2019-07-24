/*
1026 程序运行时间 (15 分)
要获得一个 C 语言程序的运行时间，常用的方法是调用头文件 time.h，其中提供了 clock() 函数，可以捕捉从程序开始运行到 clock() 被调用时所耗费的时间。
这个时间单位是 clock tick，即“时钟打点”。
同时还有一个常数 CLK_TCK，给出了机器时钟每秒所走的时钟打点数。
于是为了获得一个函数 f 的运行时间，我们只要在调用 f 之前先调用 clock()，获得一个时钟打点数 C1；
在 f 执行完成后再调用 clock()，获得另一个时钟打点数 C2；
两次获得的时钟打点数之差 (C2-C1) 就是 f 运行所消耗的时钟打点数，再除以常数 CLK_TCK，就得到了以秒为单位的运行时间。

这里不妨简单假设常数 CLK_TCK 为 100。现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。

输入格式：
输入在一行中顺序给出 2 个整数 C1 和 C2。注意两次获得的时钟打点数肯定不相同，即 C1 < C2，并且取值在 [0,10^7]。

输出格式：
在一行中输出被测函数运行的时间。运行时间必须按照 hh:mm:ss（即2位的 时:分:秒）格式输出；不足 1 秒的时间四舍五入到秒。

输入样例：
123 4577973
输出样例：
12:42:59
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int c1 = Integer.parseInt(in[0]);
        int c2 = Integer.parseInt(in[1]);
        int c = c2 - c1;
        double times = c / 100.0;
        int time = (int)times;
        if ( times - time >= 0.5 )
            time++;
        if ( time / 3600 < 10 )
            System.out.print("0");
        System.out.print(time/3600+":");
        time %= 3600;
        if ( time / 60 < 10 )
            System.out.print("0");
        System.out.print(time/60+":");
        time %= 60;
        if ( time < 10 )
            System.out.print("0");
        System.out.println(time);
    }
}