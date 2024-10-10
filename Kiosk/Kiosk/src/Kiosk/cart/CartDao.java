package Kiosk.cart;

import Kiosk.common.DatabaseConnection;
import Kiosk.product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {

  private DatabaseConnection databaseConnection;

  public CartDao() throws Exception {
    databaseConnection = new DatabaseConnection();
  }

  /*** 카트에 제품번호 존재여부 */
  public int countByProduct(int pNo) throws Exception {
    int count = 0;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.CART_COUNT_BY_P_NO);
      pstmt.setInt(1, pNo);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return count;
  }

  /*** 장바구니에 상품 추가 */
  public int insertByProduct(int cQty, int pNo) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int insertRowCount = 0;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.CART_INSERT);
      pstmt.setInt(1, cQty);
      pstmt.setInt(2, pNo);
      insertRowCount = pstmt.executeUpdate();
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return insertRowCount;
  }

  /*** 상품 상세페이지에서 상품수량 증가 */
  public int productDetailUpdateByQtyUp(int cQty, int pNo) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int insertRowCount = 0;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.PRODUCT_DETAIL_UPDATE_BY_P_NO);
      pstmt.setInt(1, cQty);
      pstmt.setInt(2, pNo);
      insertRowCount = pstmt.executeUpdate();
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return insertRowCount;
  }

  /*** 장바구니에서 상품수량 증가 */
  public int updateByQtyUp(int pNo) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int insertRowCount = 0;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_C_NO_UP);
      pstmt.setInt(1, pNo);
      insertRowCount = pstmt.executeUpdate();
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return insertRowCount;
  }

  public int updateByQtyDown(int pNo) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int insertRowCount = 0;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_C_NO_DOWN);
      pstmt.setInt(1, pNo);
      insertRowCount = pstmt.executeUpdate();
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return insertRowCount;
  }

  public int deleteByCartNo(int pNo) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int rowCount = 0;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_C_NO);
      pstmt.setInt(1, pNo);
      rowCount = pstmt.executeUpdate();
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return rowCount;
  }

  public List<Cart> findByAll() throws Exception {
    List<Cart> cartList = new ArrayList<>();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.CART_INFO_PRICE_SELECT);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Product product = new Product(
            rs.getInt("p_no"),      // Product 번호
            rs.getString("p_name"),  // Product 이름
            rs.getString("p_desc"),  // Product 설명
            rs.getString("p_type"),  // Product 종류
            rs.getInt("p_price"),    // Product 가격
            rs.getString("p_color"), // Product 색상
            rs.getString("p_img")    // Product 이미지
        );
        Cart cart = new Cart(
            rs.getInt("c_no"),
            rs.getInt("c_qty"),
            rs.getInt("p_no"),
            product
        );
        cartList.add(cart);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("SQL Error: " + e.getMessage());
    } finally {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (con != null) con.close();
    }

    return cartList;
  }

  public int deleteByCart() throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int rowCount = 0;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(CartSQL.CART_DELETE_ALL);
      rowCount = pstmt.executeUpdate();
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return rowCount;
  }

}
