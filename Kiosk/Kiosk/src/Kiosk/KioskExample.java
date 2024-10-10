package Kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class KioskExample {
  public static void main(String[] args) {

    KioskExample kioskExample = new KioskExample();
    kioskExample.showKioskExampleScreen();


}
  public void showKioskExampleScreen() {
    // 프레임 생성
    JFrame frame = new JFrame("스마트폰 키오스크");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 프레임 닫을 때 프로그램 종료 설정
    frame.setSize(500, 700);  // 프레임 크기 설정

    // 메인 화면 패널 생성
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(null);  // 수동 레이아웃 설정 (null layout)

    // 이미지 로드 (이미지 파일 경로는 사용자의 시스템 경로에 맞춰 수정 필요)
    ImageIcon originalIcon = new ImageIcon("C:\\1.Programing\\1.workspace\\IntelliJ workspace\\Kiosk\\src\\resources/galaxy-s24_main.jpg");

    // 이미지 크기를 프레임 크기에 맞게 조정
    Image originalImage = originalIcon.getImage();
    Image scaledImage = originalImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);  // 프레임 크기에 맞춰 이미지 크기 조정
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    JLabel backgroundLabel  = new JLabel(scaledIcon);  // 이미지를 JLabel에 추가
    backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

    // 환영 텍스트 추가
    JLabel welcomeLabel = new JLabel("신제품 출시!! 지금 바로 만나보세요!", SwingConstants.CENTER);  // 가운데 정렬된 텍스트 추가
    welcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));  // 폰트 설정
    welcomeLabel.setForeground(Color.BLUE);  // 텍스트 색상을 파란색으로 설정
    welcomeLabel.setBounds(0, frame.getHeight() - 100, frame.getWidth(), 50);

    // 영상 삽입할 JFXPanel 생성
    JFXPanel videoPanel = new JFXPanel();  // JavaFX와 Swing을 통합하기 위한 JFXPanel 생성
    videoPanel.setBounds(20, 200, 440, 240);  // 중앙에 위치한 비디오 패널
    videoPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent e) {
        try {
          // KioskProductMenu 객체를 생성하고 메뉴 화면으로 이동
          KioskProductMenu productMenu = new Kiosk.KioskProductMenu();
          productMenu.showProductMenuScreen(frame);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });

    // JavaFX MediaPlayer 초기화 (비디오 재생)
    Platform.runLater(() -> initFX(videoPanel));  // JavaFX MediaPlayer 설정 (JavaFX는 별도의 쓰레드에서 실행되므로 runLater 사용)

    // 메인 패널에 MouseListener 추가
    mainPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent e) {
        try {
          // KioskProductMenu 객체를 생성하고 메뉴 화면으로 이동
          KioskProductMenu productMenu = new Kiosk.KioskProductMenu();
          productMenu.showProductMenuScreen(frame);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });

    // 메인 패널에 이미지, 텍스트, 버튼 추가
    mainPanel.add(welcomeLabel);
    mainPanel.add(videoPanel);
    mainPanel.add(backgroundLabel);  // 배경 이미지를 마지막에 추가하여 가장 아래로 배치

    // 프레임에 메인 패널 추가
    frame.add(mainPanel);
    frame.setVisible(true);  // 프레임을 화면에 표시
  }

  // JavaFX MediaPlayer 설정
  private static void initFX(JFXPanel videoPanel) {
    // 비디오 파일 경로 설정 (사용자의 파일 경로로 변경 필요)
    Path mediaPath = Paths.get("src/resources/Galaxy_S24.mp4");
    Media media = new Media(mediaPath.toUri().toString());

    MediaPlayer mediaPlayer = new MediaPlayer(media);  // MediaPlayer 생성
    MediaView mediaView = new MediaView(mediaPlayer);  // MediaView를 통해 비디오 표시

    // 비디오 크기를 자동으로 비율에 맞게 맞춤
    mediaView.setFitWidth(440);  // 비디오 너비 설정
    mediaView.setFitHeight(250);  // 비디오 높이 설정
    mediaView.setPreserveRatio(true);  // 비율 유지 설정


    // JavaFX Scene 설정
    Scene scene = new Scene(new javafx.scene.Group(mediaView));  // 비디오를 포함한 장면(Scene)을 생성
    videoPanel.setScene(scene);  // JFXPanel에 장면 추가

    // 비디오 재생
    mediaPlayer.play();  // 비디오 재생 시작
  }

}