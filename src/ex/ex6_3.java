import javax.smartcardio.Card;

public class ex6_3 {
    public static void main(String[] args) {
        System.out.println("Card.width = "+Card1.width);
        System.out.println("Card.height = "+Card1.height);

        Card1 c1 = new Card1();
        c1.kind = "Heart";
        c1.number = 7;

        Card1 c2 = new Card1();
        c2.kind = "Spade";
        c2.number = 2;


        System.out.println("c1은 "+c1.kind+", "+c1.number+"이며, 크기는 ("+c1.width+", "+c1.height+")");
        System.out.println("c2은 "+c2.kind+", "+c1.number+"이며, 크기는 ("+c1.width+", "+c1.height+")");
        c1.width = 50;
        c1.height = 80;
        Card1 c3 = new Card1();
        c3.kind = "Diamonds";
        c3.number = 10;
        System.out.println("c1은 "+c1.kind+", "+c1.number+"이며, 크기는 ("+c1.width+", "+c1.height+")");
        System.out.println("c2은 "+c2.kind+", "+c1.number+"이며, 크기는 ("+c1.width+", "+c1.height+")");
        System.out.println("c3은 "+c3.kind+", "+c1.number+"이며, 크기는 ("+c1.width+", "+c1.height+")");
    }
}
