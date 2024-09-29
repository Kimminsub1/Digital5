import java.util.Random;
import java.util.Scanner;

public class ex1202_game {
    public static void main(String[] args) {
        //컴퓨터랑 가위바위보하기
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        String my, com = "";
        int comCode;

        while (true) {
            try {

                System.out.print("가아위이~ 바아위이~ 보!!!!!!!! ==> ");
                my = sc.next();
                if (my.equals("가위") || my.equals("바위") || my.equals("보")) {
                    break;
                }
                continue;
            } catch (Exception e) {
                sc.nextLine();
                continue;
            }
        }
        comCode = rd.nextInt(3);
        if (comCode == 0) {
            com = "가위";
        } else if (comCode == 1) {
            com = "바위";
        } else if (comCode == 2) {
            com = "보";
        }
        System.out.print("가아위이~ 바아위이~ 보!!!!!!!! ==> ");
        System.out.println(com);
        comCode = rd.nextInt(3);
        if (my.equals(com)) {
            System.out.println("비겼습니다. ㅡ.ㅡ");
        } else if (my.equals("가위") && com.equals("바위") || my.equals("바위") && com.equals("보") || my.equals("보") && com.equals("가위")) {
            System.out.println("졌습니다. ㅠㅠ");
        } else if (com.equals("가위") && my.equals("바위") || com.equals("바위") && my.equals("보") || com.equals("보") && my.equals("가위")) {
            System.out.println("이겼습니다. ^^ ");
        }
    }
}
