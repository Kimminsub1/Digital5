import java.util.Scanner;

public class ex02_swich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age, addr, disc, choice;

        System.out.println("어서오세요~ GIGABOX 영화관입니다.");
        System.out.print("나이를 알려주세요~ : ");
        age = sc.nextInt();
        int pay = 1;
        int kt = 10;
        int lg = 13;
        int skt = 14;

        //나이 선택
        if ((age > 0 && age < 5)) {
            System.out.println("유아 입니다.");
        } else if ((age >= 5 && age <= 12)) {
            pay = 2000;
            System.out.println("어린이 입니다.");
            System.out.printf("어린이 입장료는 %d원 입니다. \n", pay);

        } else if ((age >= 13 && age <= 19)) {
            pay = 3000;
            System.out.println("청소년 입니다.");
            System.out.printf("청소년 입장료는 %d원 입니다. \n", pay);
        } else if ((age >= 20 && age <= 60)) {
            pay = 6000;
            System.out.println("성인 입니다.");
            System.out.printf("성인 입장료는 %d원 입니다. \n", pay);
        } else if ((age >= 61 && age <= 100)) {
            System.out.println("노인 입니다.");
            System.out.println("노인 입장료는 무료 입니다.");
        }

        //거주지할인 선택
        System.out.println("구로 거주시 15% 할인됩니다.");
        System.out.print("구로에 거주하십니까? (1:Yes / 2:No) : ");
        addr = sc.nextInt();
        if (addr == 1) {
            System.out.printf("구로 거주 15%% 할인되어 %d원 입니다. \n", pay -= pay * 0.15);
        } else {
            System.out.printf("구로에 거주하지 않아 기본요금 %d 입니다. \n", pay);
        }

        //카드할인 선택
        System.out.println("카드할인 하시겠습니까? (1:Yes / 2:No) : ");
        disc = sc.nextInt();
        if (disc == 1) {
            System.out.println("어떤 카드할인 하시겠습니까? (1.kt:10% / 2.lg:13% / 3.skt:14%) : ");
            //통신사 선택
            choice = sc.nextInt();
            if (choice == 1) {
//                pay -= pay * kt / 100;
                System.out.printf("카드할인 %d%% 할인되어 %d원 입니다.", kt, pay -= pay * kt / 100);
            } else if (choice == 2) {
                System.out.printf("카드할인 %d%% 할인되어 %d원 입니다.", lg, pay -= pay * lg / 100);
            } else if (choice == 3) {
                System.out.printf("카드할인 %d%% 할인되어 %d원 입니다.", skt, pay -= pay * skt / 100);
            } else {
                System.out.printf("카드할인을 받지 않아 최종요금은 %d 입니다.", pay);
            }
        } else {
            System.out.printf("구로에 거주하지 않아 기본요금 %d 입니다.", pay);
        }
    }
}
