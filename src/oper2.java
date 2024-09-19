import java.util.Random;
import java.util.Scanner;

public class oper2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int a;
        int b;
        a = sc.nextInt();
        b = rd.nextInt(5)+2;
        System.out.println(b);
        System.out.printf("%d",a/b);
        System.out.println(a%b);
    }
}
