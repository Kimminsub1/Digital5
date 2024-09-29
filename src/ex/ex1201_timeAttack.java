import java.util.Scanner;

public class ex1201_timeAttack {
    public static void main(String[] args) {

        //PC방 이용자의 나이 검사하기
        Scanner sc = new Scanner(System.in);
        int age;
        System.out.println("밤 10시가 넘으면 청소년은 PC방을 이용할 수 없습니다~~~");

        while (true) {
            try {

                System.out.print("나이를 입력해주세요. : ");
                age = sc.nextInt();
                if (age < 1) {
                    continue;
                }
                break;
            } catch (Exception e) {
                sc.nextLine();
                continue;
            }
        }

        if (age > 19) {
            System.out.println("즐거운 시간 보내세요. ^^");
            System.out.println("협조 감사합니다.");
        } else {
            System.out.println("잡았다! 요놈!!");
        }



    }
}
