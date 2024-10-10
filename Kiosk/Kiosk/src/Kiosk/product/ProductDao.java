package Kiosk.product;

import Kiosk.common.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

  private DatabaseConnection databaseConnection;

  public ProductDao() throws Exception {
    databaseConnection = new DatabaseConnection();
  }

  public Product findByNo(int pNo) throws Exception {
    Product product = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_NO);
      pstmt.setInt(1, pNo);
      rs = pstmt.executeQuery();
      if (rs.next()) {  // 수정: while -> if로 변경. pNo는 고유값이므로 하나의 행만 반환됨.
        product = new Product(
            rs.getInt("p_no"),
            rs.getString("p_name"),
            rs.getString("p_desc"),
            rs.getString("p_type"),
            rs.getInt("p_price"),
            rs.getString("p_color"),
            rs.getString("p_img")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("SQL Error: " + e.getMessage());
    } finally {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (con != null) con.close();
    }
    return product;
  }

  /****** 유형으로 상품 검색하여 해당하는 상품 보여주기 ******/
  public List<Product> findByType(String pType) throws Exception {
    List<Product> productList = new ArrayList<>();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_TYPE);
      pstmt.setString(1, pType);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Product product = new Product(
            rs.getInt("p_no"),
            rs.getString("p_name"),
            rs.getString("p_desc"),
            rs.getString("p_type"),
            rs.getInt("p_price"),
            rs.getString("p_color"),
            rs.getString("p_img")
        );
        productList.add(product);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("SQL Error: " + e.getMessage());
    } finally {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (con != null) con.close();
    }
    return productList;
  }

  /****** 전체상품 보여주기 ******/
  public List<Product> findByAll() throws Exception {
    List<Product> productList = new ArrayList<>();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = databaseConnection.getConnection();
      pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Product product = new Product(
            rs.getInt("p_no"),
            rs.getString("p_name"),
            rs.getString("p_desc"),
            rs.getString("p_type"),
            rs.getInt("p_price"),
            rs.getString("p_color"),
            rs.getString("p_img")
        );
        productList.add(product);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("SQL Error: " + e.getMessage());
    } finally {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (con != null) con.close();
    }
    return productList;
  }

}
