package kiosk;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class kiosk extends JFrame {

  // 상품 목록 및 가격
  private String[] menuItems = {"Burger - 5000원", "Fries - 2000원", "Soda - 1000원"};
  private int[] prices = {5000, 2000, 1000};
  private int total = 0;  // 총 금액

  // 메인 화면 패널
  private JPanel mainPanel;
  // 상품 선택 화면 패널
  private JPanel menuPanel;
  // 총 금액 라벨
  private JLabel totalLabel;

  public kiosk() {
    // 기본적인 창 설정
    setTitle("키오스크");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 메인 화면 생성
    mainPanel = new JPanel();
    JButton touchButton = new JButton("화면을 터치하세요");
    touchButton.setFont(new Font("Serif", Font.BOLD, 20));
    touchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showMenuScreen();  // 상품 선택 화면으로 전환
      }
    });
    mainPanel.add(touchButton);

    // 상품 선택 화면 생성
    menuPanel = new JPanel();
    menuPanel.setLayout(new GridLayout(menuItems.length + 1, 1));

    // 상품 버튼 추가
    for (int i = 0; i < menuItems.length; i++) {
      int index = i;  // 람다식에서 사용할 인덱스 저장
      JButton menuItemButton = new JButton(menuItems[i]);
      menuItemButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          total += prices[index];  // 선택한 상품의 가격을 총액에 더함
          totalLabel.setText("총 금액: " + total + "원");
        }
      });
      menuPanel.add(menuItemButton);
    }

    // 총 금액 표시 라벨 추가
    totalLabel = new JLabel("총 금액: 0원");
    totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
    menuPanel.add(totalLabel);

    // 메인 화면을 먼저 보여줌
    add(mainPanel);

    setVisible(true);
  }

  // 메인 화면에서 상품 선택 화면으로 전환하는 메서드
  private void showMenuScreen() {
    // 기존 메인 화면 제거
    remove(mainPanel);
    // 상품 선택 화면 추가
    add(menuPanel);
    // 화면 갱신
    revalidate();
    repaint();
  }

  public static void main(String[] args) {
    // 프로그램 실행
    new kiosk();
  }
}