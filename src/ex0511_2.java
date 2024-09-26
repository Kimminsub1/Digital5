import java.util.Scanner;

public class ex0511_2 {
    public static int Arr(int num){
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        return num;
    }
    public static int Avg(int num[]){
        int Tot=0;
        for (int i=0; i<num.length; i++){
            Tot+=num[i];
        }
        return Tot/num.length;
    }
    public static int Max(int max, int num) {
        if (max < num) {
            return num;
        } else {
            return max;
        }
    }
    public static int Min(int min, int num) {
        if (min > num) {
            return num;
        } else {
            return min;
        }
    }
    public static void main(String[] args) {

        System.out.println("6명의 국어, 수학 점수를 입력하세요.");
        int[] kor = new int[6];
        int[] math = new int[6];
        int kormax=0, mathmax = 0, kormin = 100, mathmin = 100, korTot = 0, mathTot = 0;

        for (int i=0; i<6; i++){
            System.out.print("1번 국어 : ");
            kor[i] = Arr(kor[i]);
            kormax = Max(kormax, kor[i]);
            kormin = Min(kormin, kor[i]);

            System.out.print("    수학 : ");
            math[i] = Arr(math[i]);
            mathmax = Max(kormax, math[i]);
            mathmin = Min(kormin, math[i]);
        }
        System.out.println("No. 국어 수학 평균");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%2d  %3d  %3d  %3d \n", i+1, kor[i], math[i], (kor[i]+math[i])/2);
        }

        System.out.printf("평균 %3d  %3d \n", Avg(kor), Avg(math));
        System.out.printf("최고점 %3d  %3d \n", kormax, mathmax);
        System.out.printf("최저점 %3d  %3d \n", kormin, mathmin);
    }
}
