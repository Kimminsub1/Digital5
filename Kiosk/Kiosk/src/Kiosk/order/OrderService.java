package Kiosk.order;

import Kiosk.cart.Cart;
import java.sql.Date;
import java.util.List;

public class OrderService {

  private OrderDao orderDao;

  public OrderService() throws Exception {
    orderDao = new OrderDao();
  }

  // 주문 추가
  public int addOrder(List<Cart> cartList) throws Exception {
    int o_tot_price = 0;  // 총 주문 금액
    int o_tot_count = 0; // 총 주문 수량
    // 카트에서 각 상품의 총 금액과 수량을 계산
    for (Cart cart : cartList) {
      int productPrice = (cart.getProduct().getPPrice()*cart.getcQty());
      o_tot_price += productPrice ;  // 총 주문 금액에 상품 금액 추가
      o_tot_count++;  // 총 수량 추가
    }

    // 첫 번째 상품을 기준으로 주문 설명 생성
    String o_desc = cartList.get(0).getProduct().getPName() + " 외 " + (o_tot_count - 1) + " 개";

    // 새로운 주문 생성
    Order newOrder = new Order(o_tot_price, o_desc);
    System.out.println(o_tot_price);
    System.out.println(o_desc);
    System.out.println(newOrder.toString());
    // 주문을 DB에 삽입
    int orderNo = orderDao.insertOrder(newOrder);

    return orderNo;
  }

  // 주문 날짜로 주문 조회
  public Order getOrderByDate(Date oDate) throws Exception {
    return orderDao.findByOrderDate(oDate);
  }

  // 모든 주문 조회
  public List<Order> getAllOrders() throws Exception {
    return orderDao.findOrderAll();
  }

  // 주문 삭제 (주문 번호로)
  public int removeOrder(int oNo) throws Exception {
    return orderDao.deleteOrder(oNo);
  }

  // 주문 삭제 (날짜로)
  public int removeOrderByDate(Date oDate) throws Exception {
    return orderDao.deleteOrderDate(oDate);
  }
}
