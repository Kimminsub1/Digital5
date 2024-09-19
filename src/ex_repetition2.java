import java.util.Scanner;

public class ex_repetition2 {
    public static void main(String[] args) {
        int a, b, c;
        a=1;
        b=2;
        c=1;
        Scanner sc = new Scanner(System.in);

        for (int i=2; i<10;++i ){
//            System.out.println(i+"번째");
            for (int j=1; j<10;j++ ){
                System.out.printf("%d * %d = %2d \n", i, j, i*j);
            }
        }
    }
}
