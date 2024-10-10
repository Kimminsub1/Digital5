package Kiosk.order;

public class OrderSQL {

  /*** 주문에 내역 추가 */
  public static final String ORDER_INSERT =
      "insert into order_kiosk(o_price, o_desc, o_Date, o_pay_status) values (?, ?, sysdate(), default)";
  public static final String ORDER_ITEM_INSERT =
      "insert into order_item(o_no, p_no, order_item_qty) values (?, ?, ?)";


  /*** 주문에 내역 조회 */
  public final static String ORDER_SELECT_BY_O_DATE =
      "select * from orders where o_Date=?";
  public final static String ORDER_SELECT =
      "select * from orders ";

  /*** 주문에 내역 삭제 */
  public static final String ORDER_DELETE =
      "delete from order_kiosk where o_no";
  public static final String ORDER_DELETE_DAte =
      "delete from order_kiosk where o_Date";

}
