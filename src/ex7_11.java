public class ex7_11 {
    public static void main(String[] args) {
        Child3 c = new Child3();
        c.method1();
        c.method2();
        MyInterface.staticMethod();
        MyInterface2.staticMethod();
    }
}
class Child3 extends Parent3 implements MyInterface, MyInterface2 {
    public void method1(){
        System.out.println("child 3");
    }
}
class Parent3 {
    public void method2(){
        System.out.println("m2 = child 3");
    }
}
interface MyInterface {
    default void method1(){
        System.out.println("m1 = MyInterface");
    }
    default void method2(){
        System.out.println("m2 = MyInterface");
    }
    static void staticMethod(){
        System.out.println("m1 = MyInterface");
    }
}
interface MyInterface2 {
    default void method1(){
        System.out.println("m2 = MyInterface");
    }
    static void staticMethod(){
        System.out.println("m1 = MyInterface");
    }

}