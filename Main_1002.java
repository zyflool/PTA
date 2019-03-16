import java.util.Scanner;

public class Main_1002 {
    public static void main ( String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int l = s.length();
        short[] n = new short[100];
        int num = 0;
        for(int i = 0 ; i < 100 ; i++ )
            n[i] = 0;
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            int t = c - '0';
            n[0] += t;
            int  j = 0;
            while ( n[j] >=10 ) {
                n[j+1] += n[j] / 10;
                n[j] -= 10;
                j++;
            }

            num = num < j ? j : num ;
        }
        while ( num >= 0 ) {
            switch ( n[num] ) {
                case 0:{
                    System.out.print("ling");
                    break;
                }
                case 1:{
                    System.out.print("yi");
                    break;
                }
                case 2:{
                    System.out.print("er");
                    break;
                }
                case 3:{
                    System.out.print("san");
                    break;
                }
                case 4:{
                    System.out.print("si");
                    break;
                }
                case 5:{
                    System.out.print("wu");
                    break;
                }
                case 6:{
                    System.out.print("liu");
                    break;
                }
                case 7:{
                    System.out.print("qi");
                    break;
                }
                case 8:{
                    System.out.print("ba");
                    break;
                }
                case 9:{
                    System.out.print("jiu");
                    break;
                }
            }
            if ( num != 0 )
                System.out.print(" ");
            num--;
        }
    }

}
