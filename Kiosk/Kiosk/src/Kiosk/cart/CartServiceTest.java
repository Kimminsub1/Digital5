package Kiosk.cart;

public class CartServiceTest {

  public static void main(String[] args) throws Exception {
    CartService cartService = new CartService();
    int rowCount = 0;

    /*

    int rowCount3 = cartService.addProductToCart(1, 3);
    System.out.println(cartService.viewAllCartItems());
    int rowCount4 = cartService.addProductToCart(1, 4);
    System.out.println(cartService.viewAllCartItems());
    int rowCount5 = cartService.addProductToCart(1, 5);
    System.out.println(cartService.viewAllCartItems());
    int rowCount6 = cartService.addProductToCart(1, 6);
    System.out.println(cartService.viewAllCartItems());
    int rowCount7 = cartService.addProductToCart(1, 7);
    System.out.println(cartService.viewAllCartItems());

 */

    rowCount = cartService.increaseProductQty(3);
    System.out.println(cartService.viewAllCartItems());
    rowCount = cartService.decreaseProductQty(5);
    System.out.println(cartService.viewAllCartItems());
//    rowCount = cartService.removeProductFromCart(7);
    System.out.println(cartService.viewAllCartItems());
    System.out.println(">>" + rowCount);
  }
}
