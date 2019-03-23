import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        String HighName = null ,HighNum = null,LowName = null,LowNum = null;
        int max = 0;
        int min = 101;
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        while ( n-- != 0 ) {
            String name = in.next();
            String num = in.next();
            int grade = in.nextInt();
            if ( grade > max ) {
                HighName = name;
                HighNum = num;
                max = grade;
            }
            if ( grade < min ) {
                LowName = name;
                LowNum = num;
                min = grade;
            }
        }
        System.out.println(HighName+" "+HighNum);
        System.out.println(LowName+" "+LowNum);
    }
}
