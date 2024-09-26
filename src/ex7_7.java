public class ex7_7 {
    public static void main(String[] args) {
        Car car = null;
        Engine fe = new Engine();
        Engine fe2 = null;
        fe.water();
        car = fe;   //자식에서 부모로 형변환 시 타입 명시 생략 가능
//        car.water();
        fe2 = (Engine) car; //부모에서 자식으로 형변환 시 타입 명시 생략 불가!!!!!!
        fe2.water();
    }
}
