import java.util.Scanner;

public class ex02_clock {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int h = 0, m = 0, s = 0;
        int a, b, c;
        System.out.println("알람을 맞춰주세요~");
        System.out.print("시 : ");
        a=sc.nextInt();
        System.out.print("분 : ");
        b=sc.nextInt();
        System.out.print("초 : ");
        c=sc.nextInt();

        while (h < 24) {
            while (m < 60) {
                while (s < 60) {
                    System.out.printf("현재 시간은 %d시 %d분 %d초 입니다. \n", h,m,s);
                    s++;
                    Thread.sleep(1000);
                    if (h==a && m==b && s==c) {
                        System.out.println("일어나! 출근해야지~ ^^");
                        h=24;
                        m=60;
                        s=60;
                    }
                } 
                s=0;
                m++;
            }
            m=0;
            h++;
        }
    }
}
