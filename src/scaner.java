import java.util.Random;
import java.util.Scanner;

public class scaner {
    public static void main(String[] args) {


//        Scanner in = new Scanner(System.in);
//        String in1 = in.next();
//        System.out.println(in1);

//        Random ran = new Random();
//        int ran1 = ran.nextInt(5);
//        char ran2 = (char)('a' + ran.nextInt(5));  // 랜덤은 숫자 받아서 형변환으로
//        System.out.println(ran1);
//        System.out.println(ran2);
//

        Scanner scanner = new Scanner(System.in);
        Random ran1 = new Random();

        System.out.println("두자리 정수를 하나 입력해 주세요. > ");
        int input = ran1.nextInt(10);
//        String input = scanner.nextLine();
//        int num = Integer.parseInt(input);

        System.out.println("입력내용 : "+input);
        System.out.printf("num = %d%n", input);

    }
}
