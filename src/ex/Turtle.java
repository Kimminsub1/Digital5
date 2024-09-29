public class Turtle {
    private int x = 0, y = 0; // 터틀의 위치
    private String penColor = "black"; // 펜의 색상
    private int speed = 1;
    private int width = 1;

    public void setCanvasSize(int width, int height) {
        System.out.println("Canvas size set to " + width + "x" + height);
    }

    public void speed(int speed) {
        this.speed = speed;
        System.out.println("Speed set to " + speed);
    }

    public void width(int width) {
        this.width = width;
        System.out.println("Pen width set to " + width);
    }

    public void penColor(String color) {
        this.penColor = color;
        System.out.println("Pen color set to " + color);
    }

    public void right(int angle) {
        System.out.println("Turning right by " + angle + " degrees");
    }

    public void forward(int distance) {
        System.out.println("Moving forward by " + distance + " units");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Position reset to (0, 0)");
    }

    public void outlineColor(String white) {
    }

    public void up() {

    }

    public void fillColor(String color) {
    }

    public void stamp() {
    }
}
