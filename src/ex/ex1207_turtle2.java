public class ex1207_turtle2 {
    public static void main(String[] args) {
        Turtle turtle = new Turtle();
        int x, y;
        String[] colors = {"red", "green", "magenta", "blue", "black"};

        turtle.speed(100); // 터틀 속도 설정
        turtle.outlineColor("white"); // 윤곽선 색상 설정
        turtle.setCanvasSize(330, 330); // 캔버스 크기 설정
        turtle.up(); // 펜을 들어서 이동할 때 선이 그려지지 않도록 설정

        // 그리드 생성 (7x7 그리드)
        for (int i = 0; i < 7; i++) {
            for (int k = 0; k < 7; k++) {
                x = i * 50 - 150; // x 좌표 계산
                y = k * 50 - 150; // y 좌표 계산
                turtle.setPosition(x, y); // 터틀을 해당 위치로 이동

                // 색상을 랜덤으로 선택
                int num = (int)(Math.random() * colors.length);
                turtle.fillColor(colors[num]); // 선택된 색상으로 채우기
                turtle.stamp(); // 현재 위치에 도장을 찍음 (도형을 그리는 역할)
            }
        }
            }
        }
