class ex6_1 {
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.printf("t1의 channel값은 %d입니다. \n", t1.channel);
        System.out.printf("t2의 channel값은 %d입니다. \n", t2.channel);
        t1.channel = 7;
//        t.channelDown();
        System.out.printf("t1의 channel값을 %d로 변경하였습니다. \n", t1.channel);

        System.out.printf("t1의 channel값은 %d입니다. \n", t1.channel);
        System.out.printf("t2의 channel값은 %d입니다. \n", t2.channel);
    }
}
