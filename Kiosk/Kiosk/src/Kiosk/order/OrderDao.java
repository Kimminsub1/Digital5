package Kiosk.order;

import Kiosk.common.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

  private DatabaseConnection databaseConnection;

  public OrderDao() throws Exception {
    databaseConnection = new DatabaseConnection();
  }

  // Insert order logic (fixing some issues)
  public int insertOrder(Order order) throws Exception {
    Connection con = null;
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;
    int orderNo = 0; // 주문 번호 변수

    try {
      con = databaseConnection.getConnection();
      con.setAutoCommit(false); // 트랜잭션 설정

      // 1. 주문 삽입
      pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
      pstmt1.setInt(1, order.getoPrice());
      pstmt1.setString(2, order.getoDesc());
      pstmt1.executeUpdate(); // executeUpdate()를 통해 INSERT 실행

      // 2. 생성된 주문 번호 가져오기
      rs = pstmt1.getGeneratedKeys();
      if (rs.next()) {
        orderNo = rs.getInt(1); // 첫 번째 열에서 주문 번호 추출
      } else {
        throw new Exception("주문 번호 생성 실패");
      }

      con.commit(); // 트랜잭션 커밋
    } catch (Exception e) {
      if (con != null) {
        con.rollback(); // 오류 발생 시 롤백
      }
      e.printStackTrace();
      throw e; // 예외 다시 던지기
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return orderNo; // 생성된 주문 번호 반환
  }



  public int deleteOrderDate(Date o_Date) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int rowCount = 0;
    try {
      con = databaseConnection.getConnection();
      con.setAutoCommit(false);
      pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE);
      pstmt.setDate(1, o_Date);
      rowCount = pstmt.executeUpdate();
      con.commit();
    } catch (Exception e) {
      con.rollback();
      e.printStackTrace();
      throw e;
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return rowCount;
  }

  public int deleteOrder(int o_no) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    int rowCount = 0;
    try {
      con = databaseConnection.getConnection();
      con.setAutoCommit(false);
      pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_DAte);
      pstmt.setInt(1, o_no);
      rowCount = pstmt.executeUpdate();
      con.commit();
    } catch (Exception e) {
      con.rollback();
      e.printStackTrace();
      throw e;
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return rowCount;
  }

  public Order findByOrderDate(Date o_date) throws Exception {

    Order order = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = databaseConnection.getConnection();

      // select * from orders o join order_item oi on o.oNo=oi.oNo  join  product p on oi.p_no=p.p_no where  o.oNo = ?

      pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_O_DATE);
      pstmt.setDate(1, o_date);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        order = new Order(
            rs.getInt("oNo"),
            rs.getInt("oPrice"),
            rs.getString("oDesc"),
            rs.getDate("oDate"),
            rs.getString("o_pay_status")
        );

      }
    } finally {
      if (con != null) {
        con.close();
      }
    }
    return order;
  }

  public List<Order> findOrderAll() throws Exception {

    List<Order> orderList = new ArrayList<Order>();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = databaseConnection.getConnection();

      pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Order order = new Order(
            rs.getInt("oNo"),
            rs.getInt("oPrice"),
            rs.getString("oDesc"),
            rs.getDate("oDate"),
            rs.getString("o_pay_status")
        );
        orderList.add(order);
      }


    } finally {
      if (con != null) {
        con.close();
      }
    }
    return orderList;
  }

}
