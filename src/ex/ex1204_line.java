import java.util.Scanner;

public class ex1204_line {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int std, result=1;
        while (true) {
            try {
                System.out.print("학생 수 ==> ");
                std = sc.nextInt();
                if (std < 0) {
                    continue;
                }
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        for (int i=1; i<=std; i++){
            result*=i;
        }
        for (int j=0; j<std; j++){
            System.out.print((char) (65+j));
            if (j!=std-1){
                System.out.print(", ");
            }
        }

        System.out.printf(" 학생들을 순서대로 세우는 경우의 수 : %d \n", result);
    }
}
