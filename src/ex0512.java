import java.util.Scanner;

public class ex0512 {
    public static int Method(int num){
        int a = 10;
        if (num % 2 == 0) {
            System.out.println("짝수입니다.");
        }else {
            System.out.println("홀수입니다.");
        }
        return a;
    }
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        while (true) {
            num = sc.nextInt();
            Method(num);
            System.out.println(Method(3));
        }
    }
}
