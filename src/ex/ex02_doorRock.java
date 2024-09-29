import java.util.Scanner;

public class ex02_doorRock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, ans1, ans2, ans3;
        String d, ans4;
        System.out.print("비밀번호를 설정하세요. : ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.next();
        System.out.print("비밀번호를 입력하세요. : ");
        ans1 = sc.nextInt();
        ans2 = sc.nextInt();
        ans3 = sc.nextInt();
        ans4 = sc.next();
        if (a == ans1) {
            if (b == ans2) {
                if (c == ans3) {
                    if (d.equals(ans4)) {
                        System.out.println("문이 열립니다.");
                    } else {
                        System.out.println("비밀번호가 틀립니다.");
                    }
                } else {
                    System.out.println("비밀번호가 틀립니다.");
                }
            } else {
                System.out.println("비밀번호가 틀립니다.");
            }
        } else {
            System.out.println("비밀번호가 틀립니다.");
        }
    }
}
