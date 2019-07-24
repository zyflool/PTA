/*
1028 人口普查 (20 分)
某城镇进行人口普查，得到了全体居民的生日。现请你写个程序，找出镇上最年长和最年轻的人。
这里确保每个输入的日期都是合法的，但不一定是合理的——假设已知镇上没有超过 200 岁的老人，
而今天是 2014 年 9 月 6 日，所以超过 200 岁的生日和未出生的生日都是不合理的，应该被过滤掉。

输入格式：
输入在第一行给出正整数 N，取值在(0,10^5]；
随后 N 行，每行给出 1 个人的姓名（由不超过 5 个英文字母组成的字符串）、以及按 yyyy/mm/dd（即年/月/日）格式给出的生日。
题目保证最年长和最年轻的人没有并列。

输出格式：
在一行中顺序输出有效生日的个数、最年长人和最年轻人的姓名，其间以空格分隔。

输入样例：
5
John 2001/05/12
Tom 1814/09/06
Ann 2121/01/30
James 1814/09/05
Steve 1967/11/20
输出样例：
3 Tom John
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {
    public final static DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

    static class Person implements Comparable<Person> {
        public String name;
        public Date brithday;

        Person(String name, Date birthday) {
            this.name = name;
            this.brithday = birthday;
        }

        @Override
        public int compareTo(Person p) {
            return this.brithday.compareTo(p.brithday);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Date now = df.parse("2014/09/06");
        Date from = df.parse("1814/09/06");
        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            String pn = temp[0];
            Date date = df.parse(temp[1]);
            if (date.compareTo(now) <= 0 && date.compareTo(from) >= 0) {
                list.add(new Person(pn, date));
            }
        }
        if (list.size() > 0) {
            Collections.sort(list);
            System.out.print(list.size() + " " + list.get(0).name + " "
                    + list.get(list.size() - 1).name);
        } else {
            System.out.println(0);
        }
    }
}