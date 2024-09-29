import java.util.Scanner;

public class ex1203_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;
        while (true) {
            try {
                System.out.print("출생 연도를 입력하세요 ==> ");
                year = sc.nextInt();
                if (year < 0) {
                    continue;
                }
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        if (year%12==0) {
            System.out.println("원숭이띠");

        } else if (year%12==1) {
            System.out.println("닭띠");

        } else if (year%12==2) {
            System.out.println("개띠");

        } else if (year%12==3) {
            System.out.println("돼지띠");

        } else if (year%12==4) {
            System.out.println("쥐띠");

        } else if (year%12==5) {
            System.out.println("소띠");

        } else if (year%12==6) {
            System.out.println("호랑이띠");

        } else if (year%12==7) {
            System.out.println("토끼띠");

        } else if (year%12==8) {
            System.out.println("용띠");

        } else if (year%12==9) {
            System.out.println("뱀띠");

        } else if (year%12==10) {
            System.out.println("말띠");

        } else if (year%12==11) {
            System.out.println("양띠");
        }

    }
}
