package Kiosk.cart;

public class CartSQL {

  /*** 장바구니에 상품 추가 */
  public static final String CART_INSERT =
      "insert into CART(c_qty, p_no) values (?, ?)";

  /*** 카트에 제품번호 존재여부 */
  public static final String CART_COUNT_BY_P_NO =
      "select count(*) as p_count from cart where p_no=?";

  /*** 장바구니번호를 검색하여 장바구니 삭제 */
  public static final String CART_DELETE_BY_C_NO =
      "delete from cart where p_no = ?";

  /*** 장바구니에서 상품수량 증가 */
  public static final String CART_UPDATE_BY_C_NO_UP =
      "update cart set c_qty=c_qty+1 where p_no=?";

  /*** 장바구니에서 상품수량 감소 */
  public static final String CART_UPDATE_BY_C_NO_DOWN =
      "update cart set c_qty=c_qty-1 where p_no=?";

  /*** 장바구니에서 상품수량 변경 */
  public static final String PRODUCT_DETAIL_UPDATE_BY_P_NO =
      "update cart set c_qty=c_qty+? where p_no=?";

  /*** 장바구니에 등록된 상품과 상품정보 */
  public static final String CART_INFO_PRICE_SELECT =
      "select c.*,p.*,c.c_qty*p.p_price 상품가격 from cart c join product p on c.p_no=p.p_no";
  public static final String CART_DELETE_ALL =
      "delete from cart";

}
