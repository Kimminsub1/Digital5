package Kiosk;// Import necessary classes

import Kiosk.cart.Cart;
import Kiosk.cart.CartService;
import Kiosk.order.OrderService;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CartPage {

  // 현재 시간을 기반으로 java.sql.Date 객체 생성
  java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

  // java.util.Date로 생성 후 java.sql.Date로 변환
  java.util.Date utilDate = new java.util.Date();
  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
  private CartService cartService;
  private OrderService orderService;

  public CartPage() throws Exception {
    cartService = new CartService();
    orderService = new OrderService(); // Initialize OrderService
  }

  // 장바구니 페이지를 표시하는 함수
  public void showCartPage(JFrame frame) throws Exception {
    frame.getContentPane().removeAll();  // 기존 화면 제거
    frame.repaint();

    JPanel cartPanel = new JPanel();
    cartPanel.setLayout(new GridLayout(0, 1, 10, 10));  // 행 단위로 상품 표시

    // 장바구니의 모든 상품을 가져옴
    List<Cart> cartList = cartService.viewAllCartItems();

    for (Cart cart : cartList) {
      JPanel cartItemPanel = new JPanel(new BorderLayout());

      // 상품 정보 표시
      JLabel nameLabel = new JLabel(cart.getProduct().getPName() + "  /  수량: " + cart.getcQty() + "  /  가격: " + (cart.getcQty()*cart.getProduct().getPPrice()),
          JLabel.CENTER);
      cartItemPanel.add(nameLabel, BorderLayout.CENTER);

      // 수량 증가/감소 버튼
      JButton increaseQtyButton = new JButton("+");
      JButton decreaseQtyButton = new JButton("-");
      JButton removeButton = new JButton("삭제");

      increaseQtyButton.addActionListener(e -> {
        try {
          cartService.increaseProductQty(cart.getpNo());
          showCartPage(frame);  // 페이지 갱신
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      });

      decreaseQtyButton.addActionListener(e -> {
        try {
          cartService.decreaseProductQty(cart.getpNo());
          showCartPage(frame);  // 페이지 갱신
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      });

      removeButton.addActionListener(e -> {
        try {
          cartService.removeProductFromCart(cart.getpNo());
          showCartPage(frame);  // 페이지 갱신
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(increaseQtyButton);
      buttonPanel.add(decreaseQtyButton);
      buttonPanel.add(removeButton);

      cartItemPanel.add(buttonPanel, BorderLayout.EAST);

      cartPanel.add(cartItemPanel);
    }

    // 결제하기 버튼 추가
    JButton checkoutButton = new JButton("주문하기");
    checkoutButton.addActionListener(e -> {
      try {
        processCheckout(cartList, frame); // Checkout process
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });

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

    JPanel bottomPanel = new JPanel();
    bottomPanel.add(backButton);
    bottomPanel.add(checkoutButton);

    frame.add(new JScrollPane(cartPanel), BorderLayout.CENTER);
    frame.add(bottomPanel, BorderLayout.SOUTH);
    frame.revalidate();
  }

  // 주문을 처리하는 메서드
  private void processCheckout(List<Cart> cartList, JFrame frame) throws Exception {
    if (cartList.isEmpty()) {
      JOptionPane.showMessageDialog(frame, "장바구니가 비어 있습니다.", "주문 오류", JOptionPane.ERROR_MESSAGE);
      return;
    }

    int totalPrice = 0;
    for (Cart cart : cartList) {
      totalPrice += cart.getcQty() * cart.getProduct().getPPrice(); // 상품 수량과 가격을 곱하여 총액에 추가
    }
    orderService.addOrder(cartList); // cartList를 OrderService로 전달

    JOptionPane.showMessageDialog(frame, "총 금액: " + totalPrice + "원\n주문이 완료되었습니다!");

    // 장바구니 비우기 (주문 후)
    cartService.clearCart();

    // 메뉴 화면으로 이동
    KioskProductMenu productMenu = new KioskProductMenu();
    productMenu.showProductMenuScreen(frame);
  }
}
