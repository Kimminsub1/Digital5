package Kiosk.cart;

import java.util.List;

public class CartService {

  private CartDao cartDao;

  public CartService() throws Exception {
    cartDao = new CartDao();
  }

  /*** 카트에 제품번호 존재여부 확인 */
  public boolean isProductInCart(int pNo) throws Exception {
    int count = cartDao.countByProduct(pNo);
    return count > 0;
  }

  /*** 장바구니에 상품 추가 */
  public int addProductToCart(int cQty, int pNo) throws Exception {
    // 만약 카트에 동일한 제품이 있으면 수량을 추가하고, 없으면 새로 추가
    if (isProductInCart(pNo)) {
      return cartDao.productDetailUpdateByQtyUp(cQty, pNo);
    } else {
      return cartDao.insertByProduct(cQty, pNo);
    }
  }


  /*** 장바구니에서 상품수량 증가 */
  public int increaseProductQty(int pNo) throws Exception {
    Cart cart = new Cart(0, 0, pNo);
    return cartDao.updateByQtyUp(pNo);
  }

  /*** 장바구니에서 상품수량 감소 */
  public int decreaseProductQty(int pNo) throws Exception {
    Cart cart = new Cart(0, 0, pNo);
    return cartDao.updateByQtyDown(pNo);
  }

  /*** 장바구니에서 상품 삭제 */
  public int removeProductFromCart(int pNo) throws Exception {
    return cartDao.deleteByCartNo(pNo);
  }

  /*** 장바구니의 모든 상품 보기 */
  public List<Cart> viewAllCartItems() throws Exception {
    return cartDao.findByAll();
  }

  public void clearCart() throws  Exception {
    cartDao.deleteByCart();
  }
}
