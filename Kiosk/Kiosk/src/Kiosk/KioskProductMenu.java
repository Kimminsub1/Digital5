package Kiosk;

import Kiosk.cart.CartService;
import Kiosk.product.Product;
import Kiosk.product.ProductService;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class KioskProductMenu {

  private ProductService productService;
  private CartService cartService;
  private ProductDetailPage productDetailPage;

  public KioskProductMenu() throws Exception {
    productService = new ProductService();
    cartService = new CartService();
    productDetailPage = new ProductDetailPage();
  }

  // 메뉴 화면을 표시하는 함수
  public void showProductMenuScreen(JFrame frame) throws Exception {
    frame.getContentPane().removeAll();  // 기존 화면의 모든 컴포넌트를 제거
    frame.repaint();  // 프레임을 새로 고침

    // JTabbedPane을 사용하여 카테고리별로 탭을 나눔
    JTabbedPane tabbedPane = new JTabbedPane();

    String[] categories = {"All", "Basics", "Plus", "Ultra"};

    // 각 카테고리별로 탭을 추가
    for (String category : categories) {
      JPanel categoryPanel = new JPanel(new GridLayout(0, 3, 10, 10));  // 3개의 열로 구성된 그리드 레이아웃
      List<Product> productList;

      // 'All'인 경우 전체 상품 목록을 가져옴
      if (category.equals("All")) {
        productList = productService.productAllList();
      } else {
        // 특정 카테고리 상품 목록을 가져옴
        productList = productService.productTypeList(category);
      }

      for (Product product : productList) {
        // 각각의 상품을 위한 패널 생성 (이미지와 텍스트 포함)
        JPanel productPanel = new JPanel(new BorderLayout());

        // 상품 이미지가 있는 경우 이미지 추가
        if (product.getPImg() != null && !product.getPImg().isEmpty()) {
          ImageIcon productIcon = new ImageIcon(
              "C:\\1.Programing\\1.workspace\\IntelliJ workspace\\Kiosk\\src\\resources/"
                  + product.getPImg());

          Image img = productIcon.getImage();
          Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
          ImageIcon scaledIcon = new ImageIcon(scaledImg);
          JLabel imageLabel = new JLabel(scaledIcon);
          productPanel.add(imageLabel, BorderLayout.CENTER);
        }

        // 상품 이름 라벨 추가 (아래쪽)
        JLabel nameLabel = new JLabel(product.getPName(), JLabel.CENTER);
        productPanel.add(nameLabel, BorderLayout.SOUTH);

        // 상품 패널에 클릭 이벤트 추가 - 상세보기 페이지로 이동
        productPanel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            try {
              productDetailPage.showProductDetail(frame, product);
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });

        categoryPanel.add(productPanel);
      }
      // 해당 카테고리를 탭에 추가
      tabbedPane.addTab(category, categoryPanel);
    }
    // 장바구니로 이동하는 버튼 추가
    JButton viewCartButton = new JButton("장바구니 보기");
    viewCartButton.addActionListener(e -> {
      try {
        CartPage cartPage = new CartPage();
        cartPage.showCartPage(frame);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });

    frame.add(tabbedPane, BorderLayout.CENTER);
    frame.add(viewCartButton, BorderLayout.SOUTH);
    frame.revalidate();  // 레이아웃을 다시 계산하고 업데이트
  }
}
