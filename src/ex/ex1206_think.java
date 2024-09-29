import java.util.Random;
import java.util.Scanner;

public class ex1206_think {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        for (int i=0; i<10; i++) {
            int com = rd.nextInt(5)+1;
            System.out.printf("게임 %d회 : 컴퓨터가 생각한 숫자는? ", i+1);
            int my = sc.nextInt();
            if (my==com){
                System.out.println("맞혔네요. 축하합니다!!");
                break;
            }else {
                System.out.printf("아까워요. %d였는데요. 다시 해보세요. ㅠ \n", com);
            }
        }


    }
}
