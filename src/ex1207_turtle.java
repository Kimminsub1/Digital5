public class ex1207_turtle {
    public static void main(String[] args) {
        // 터틀 객체 생성
        Turtle turtle = new Turtle();
        int angle, distance, curX, curY;

        // 터틀의 속도 설정 (500으로 빠르게 설정)
        turtle.speed(500);

        // 캔버스 크기 설정 (300 x 300)
        turtle.setCanvasSize(300, 300);

        // 펜 굵기 설정 (5)
        turtle.width(5);

        // 펜 색상을 파란색으로 설정
        turtle.penColor("blue");

        // 무한 반복문 시작
        while (true) {
            // 각도와 거리를 랜덤으로 설정
            angle = (int)(Math.random() * 360); // 0~360도 사이 랜덤 각도
            distance = (int)(Math.random() * 90 + 10); // 10~100 사이 랜덤 거리

            // 터틀을 랜덤 각도만큼 회전
            turtle.right(angle);

            // 설정된 거리만큼 앞으로 이동
            turtle.forward(distance);

            // 현재 터틀의 X, Y 좌표를 가져옴
            curX = (int)turtle.getX();
            curY = (int)turtle.getY();

            // 터틀이 (-150, 150) 범위 안에 있는지 확인
            if ((curX >= -150 && curX <= 150) && (curY >= -150 && curY <= 150)) {
                // 범위 내에 있으면 메시지 출력
                System.out.println("Good Boy ~");
            } else {
                // 범위를 벗어나면 터틀의 위치를 (0, 0)으로 리셋
                turtle.setPosition(0, 0);
            }
        }

            }
        }
