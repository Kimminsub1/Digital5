public class Tv {
    String color;
    boolean power;
    int channel;
    int channel2=10;

    void power() {power = !power;}
    void channelUp() {++channel;}
    void channelDown() {--channel;}
}
