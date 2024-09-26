import java.util.Scanner;

public class ex0510 {
    public static void main(String[] args) {
        String[][] words = {
                {"computer", "컴퓨터"}, {"chair","의자"}, {"integer","정수"}
        };
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < words.length; i++) {
            System.out.printf("Q%d. %s의 뜻은 : ", i + 1, words[i][0]);
            String ans = sc.nextLine();
            if (words[i][1].equals(ans)){
                System.out.println("정답");
            }else {
                System.out.println("땡!");
            }
        }
    }
}
