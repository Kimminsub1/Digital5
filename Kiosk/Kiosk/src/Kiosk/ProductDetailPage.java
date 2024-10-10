package Kiosk;

import Kiosk.cart.CartService;
import Kiosk.product.Product;

import javax.swing.*;
import java.awt.*;

public class ProductDetailPage {

  private CartService cartService;

  public ProductDetailPage() throws Exception {
    cartService = new CartService();
  }

  // 상품 상세보기 페이지를 표시하는 함수
  public void showProductDetail(JFrame frame, Product product) throws Exception {
    frame.getContentPane().removeAll();  // 기존 화면 제거
    frame.repaint();

    JPanel detailPanel = new JPanel(new BorderLayout());

    // 상품 이미지
    if (product.getPImg() != null && !product.getPImg().isEmpty()) {
      ImageIcon productIcon = new ImageIcon(
          "C:\\1.Programing\\1.workspace\\IntelliJ workspace\\Kiosk\\src\\resources/"
              + product.getPImg());

      Image img = productIcon.getImage();
      Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
      ImageIcon scaledIcon = new ImageIcon(scaledImg);

      JLabel imageLabel = new JLabel(scaledIcon);
      detailPanel.add(imageLabel, BorderLayout.NORTH);
    }

    // 상품 정보 표시
    JTextArea productInfo = new JTextArea();
    productInfo.setEditable(false);
    productInfo.setLineWrap(true);  // 자동 줄바꿈 설정
    productInfo.setWrapStyleWord(true);  // 단어 단위로 줄바꿈

// 영역 설정 (너비 300px, 높이 200px 정도로 설정)
    productInfo.setPreferredSize(new Dimension(300, 200));

    productInfo.setText(
        "모델명\t : " + product.getPName() + "\n" +
            "가격\t : " + product.getPPrice() + "원 " + "\n" +
            "제품설명\t : " + product.getPDesc());
    detailPanel.add(productInfo, BorderLayout.CENTER);

    JScrollPane scrollPane = new JScrollPane(productInfo);  // 스크롤 가능하도록 설정
    detailPanel.add(scrollPane, BorderLayout.CENTER);

    // 수량 선택 및 장바구니에 담기 버튼
    JPanel actionPanel = new JPanel(new FlowLayout());  // FlowLayout을 사용하여 버튼을 가로로 배치

    JLabel qtyLabel = new JLabel("수량:");
    JTextField qtyField = new JTextField("1", 5);

    JButton addToCartButton = new JButton("장바구니에 담기");
    addToCartButton.addActionListener(e -> {
      try {
        int qty = Integer.parseInt(qtyField.getText());
        cartService.addProductToCart(qty, product.getPNo());
        JOptionPane.showMessageDialog(frame, "상품이 장바구니에 추가되었습니다!");
      } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "장바구니 추가 중 오류가 발생했습니다.");
      }
    });

    actionPanel.add(qtyLabel);
    actionPanel.add(qtyField);
    actionPanel.add(addToCartButton);

// 뒤로 가기 버튼
    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(e -> {
      try {
        KioskProductMenu productMenu = new KioskProductMenu();
        productMenu.showProductMenuScreen(frame);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });

// 버튼들을 포함할 하단 패널
    JPanel bottomPanel = new JPanel(new BorderLayout());
    bottomPanel.add(actionPanel, BorderLayout.CENTER);  // 가운데에 장바구니 추가 버튼 패널
    bottomPanel.add(backButton, BorderLayout.EAST);     // 오른쪽에 뒤로가기 버튼

    detailPanel.add(bottomPanel, BorderLayout.SOUTH);  // 하단에 bottomPanel 추가

    frame.add(detailPanel);
    frame.revalidate();
  }
}