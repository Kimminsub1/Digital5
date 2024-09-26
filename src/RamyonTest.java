import java.util.Scanner;

public class RamyonTest {
    public static void main(String[] args) {
        int s;

        do {
            System.out.print("만들고 싶은 요리를 입력하세요. (1:일반라면, 2:떡라면, 3:치즈라면, 99:종료) : ");
            Scanner sc = new Scanner(System.in);
            s = sc.nextInt();
            if (s == 1) {
                Ramyon r = new Ramyon();
                r.boilwater();
                r.cooking();
            } else if (s == 2) {
                RiceRamyon rr = new RiceRamyon();
                rr.boilwater();
                rr.topping();
                rr.cooking();
            } else if (s == 3) {
                CheeseRamyon cr = new CheeseRamyon();
                cr.boilwater();
                cr.topping();
                cr.cooking();
            }
        } while (s != 99);
        System.out.printf("Thank you");
    }
}
