package Kiosk.order;

import Kiosk.cart.CartDao;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest {

  private OrderDao orderDao;
  private CartDao cartDao;
  public OrderServiceTest() throws Exception{
    orderDao=new OrderDao();
    cartDao=new CartDao();

  }

  public List<Order> create(int oPrice, String oDesc, Date oDate,int pNo) throws Exception{

    CartDao cartDao=new CartDao();

    ArrayList<Order> orderList=new ArrayList<Order>();
    orderList.add((Order) cartDao.findByAll());


    return orderList;

  }

  public int deleteByOrderNo(int oNo)throws Exception{
    return orderDao.deleteOrder(3);
  }

  public List<Order> orderWithOrderItemList() throws Exception{
    return orderDao.findOrderAll();
  }

}
