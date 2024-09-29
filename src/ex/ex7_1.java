import java.nio.channels.Channel;

public class ex7_1 {
    public static void main(String[] args) {
        SmartTv stv = new SmartTv();
//        Tv tv = new Tv();
        stv.channel = 10;
        stv.channelUp();
        System.out.println(stv.channel);
        stv.displayCaption("Hello, World");
        stv.caption = true;
        stv.displayCaption("caption:on = Hello, World");
        System.out.println(stv.channel2);
        stv.channel2=7;
        System.out.println(stv.channel2);
//        System.out.println(tv.channel2);
//        tv.displayCaption  error 이유 = 상속은 자식이 부모에게 받아서 사용하는것, 부모는 자식 코드를 받아서 쓸 수 없다.
    }
}
