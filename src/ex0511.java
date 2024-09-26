import java.util.Scanner;

public class ex0511 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("6명의 국어, 수학 점수를 입력하세요.");
        int[][] score = new int[2][6];
        int kormax = 0;
        int kormin = 100;
        int mathmax = 0;
        int mathmin = 100;
        int korTot = 0;
        int mathTot = 0;

        for (int i=0; i<6; i++){
            System.out.print("1번 국어 : ");
            score[0][i] = sc.nextInt();
            korTot+=score[0][i];
            if (kormax < score[0][i]) {
                kormax = score[0][i];
            } else if (kormin>score[0][i]) {
                kormin = score[0][i];
            }
            System.out.print("    수학 : ");
            score[1][i] = sc.nextInt();
            mathTot+=score[1][i];
            if (mathmax < score[1][i]) {
                mathmax = score[1][i];
            } else if (mathmin>score[1][i]) {
                mathmin = score[1][i];
            }
        }
        System.out.println("No. 국어 수학 평균");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%2d  %3d  %3d  %3d \n", i+1, score[0][i], score[1][i], (score[0][i]+score[1][i])/2);
        }

        System.out.printf("평균 %3d  %3d \n", korTot/6, mathTot/6);
        System.out.printf("최고점 %3d  %3d \n", kormax, mathmax);
        System.out.printf("최저점 %3d  %3d \n", kormin, mathmin);
    }
}
