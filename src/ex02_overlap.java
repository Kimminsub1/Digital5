import java.util.Random;
import java.util.Scanner;

public class ex02_overlap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (1 == ans) {
            //실행문
            if (a==1){

                if (b==1){

                    System.out.println("김민섭");

                }else {
                    System.out.println("정답이 아니입니다. ");

                }
            }else {
                System.out.println("정답이 아니입니다. ");

            }
        } else {
            //실행문
            System.out.println("정답이 아니입니다. ");
        }
        System.out.println(" 끄읕~ ");
    }
}
