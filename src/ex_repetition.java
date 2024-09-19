import java.util.Scanner;

public class ex_repetition {
    public static void main(String[] args) {
        int a, b, c;
        a=10;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("내가 살고있는 곳은? : ");
            String s = sc.next();
            System.out.println(s);
            System.out.println("계속 하실?");
            int n = sc.nextInt();
            if (n==1){

            }else {
                a-=5;
            }
        }
        while (a==0);
    }
}
