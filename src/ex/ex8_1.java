package ex;

public class ex8_1 {
    public static void main(String args[]){
        System.out.println(1);
        try {
            System.out.println(2);
//            throw new Exception("예외 발생!!!!!!");
            System.out.println(0/0);
            System.out.println(3);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
            e.printStackTrace();
            System.out.println("예외 발생 : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(5);
    }
}
