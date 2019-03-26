import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] record = new int[150];
        for ( int i = 0 ; i < 150 ; i++ )
            record[i] = 0;

        ArrayList<Integer> m = new ArrayList<>();
        for ( int i = 0 ; i < n ; i++ ) {
            int tmp =in.nextInt();
            m.add(tmp);
            record[tmp] = 1 ;
        }
        for (int i = 0 ; i < n ; i++ ) {
            if ( record[m.get(i)] != 0 ) {
                callatz(m.get(i), record);
                System.out.printf(m.get(i)+": ");
                for (int j = 0; j < 150; j++) {
                    if (record[j] == 1)
                        System.out.print(j + " ");
                }
                System.out.println();
            }
        }

        m.clear();
        for ( int i = 149 ; i > 0 ; i-- ) {
            if (record[i] == 1)
                m.add(i);
        }

        for ( int i = 0 ; i < m.size() ; i++ ) {
            System.out.print(m.get(i));
            if (i != m.size() - 1 )
                System.out.print(" ");
        }

    }
    public static void callatz(int n, int[] rec) {
        if ( n%2 != 0 )
            n = ( 3 * n + 1 ) / 2;
        else  n = n / 2;
        while ( n != 1 ) {
            rec[n] = 0;
            if ( n%2 != 0 )
                n = ( 3 * n + 1 ) / 2;
            else  n = n / 2;
            rec[n] = 0;
        }
    }
}