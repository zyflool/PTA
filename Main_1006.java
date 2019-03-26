import java.util.Scanner;

public class Main
{
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if ( n/100 >= 1 )
            B(n / 100 );
        if ( n / 10 >= 1 )
            S(n%100/10 );
        if ( n >= 1 )
            N(n%100%10 );
    }

    public static void B ( int x ) {
        for (int i = 1 ; i <= x ; i ++)
            System.out.print("B");
    }

    public static void S ( int y ) {
        for (int i = 1 ; i <= y ; i++ )
            System.out.print("S");
    }

    public static void N(int z) {
        for (int i = 1 ; i <= z ; i++ )
            System.out.print(i);
    }
}
