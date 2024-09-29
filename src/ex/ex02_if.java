import java.util.Random;
import java.util.Scanner;

public class ex02_if {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.print("숫자를 입력하세요. : ");
        int game = rd.nextInt(10)+1;
        int ans = sc.nextInt();

        if (game == ans) {
            //실행문
            System.out.println("정답입니다. ");

        } else {
            //실행문
            System.out.println("정답이 아니입니다. ");
        }
        System.out.println(game);
        System.out.println(" 끄읕~ ");
    }
}
