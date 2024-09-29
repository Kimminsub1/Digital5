public class ex04_19 {
    public static void main(String[] args) {
        int score1 = 100;
        int score2 = 90;
        int score3 = 50;
        int score4 = 95;
        int score5 = 85;

        int sum1 = score1;
        sum1 += score2;
        sum1 += score3;
        sum1 += score4;
        sum1 += score5;

        double average = sum1 / 5.0;

        System.out.println(sum1);
        System.out.println(average);

//----------------------------------------------------

        int scores[][] = {{100, 90, 50, 95, 85},{50, 30, 70, 45},{100}};
        int sum2 = 0;

        for (int i = 0; i < 5; i++) {
//            sum2 += scores[i];
        }

        double average2 = sum2 / 5.0;

        System.out.println(sum2);
        System.out.println(average2);
        System.out.println(scores);
        System.out.println(scores[0]);
        System.out.println(scores[2]);
        System.out.println(scores[3]);
        System.out.println(scores.toString());
    }
}
