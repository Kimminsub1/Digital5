import java.util.Random;

public class ex1205_dice {
    public static void main(String[] args) {
        Random rd = new Random();
        int dice1, dice2, dice3, count=0;

        while (true){
            dice1 = rd.nextInt(6)+1;
            dice2 = rd.nextInt(6)+1;
            dice3 = rd.nextInt(6)+1;
            count++;
            if (dice1==dice2 && dice2==dice3){
                System.out.printf("3개 주사위는 모두 %d 입니다. \n", dice1);
                System.out.printf("같은 숫자가 나올 때 까지 %d 번 던졌습니다. \n", count);
                break;
            }
        }
    }
}
