package Kiosk.cart;

import Kiosk.product.Product;


public class Cart {

  private int cNo;
  private int cQty;
  private int pNo;
  private Product product;


  public Cart(int cNo, int cQty, int pNo) {
  }

  public Cart(int cNo, int cQty, int pNo, Product product) {
    this.cNo = cNo;
    this.cQty = cQty;
    this.pNo = pNo;
    this.product = product;
  }

  public int getcNo() {
    return cNo;
  }

  public void setcNo(int cNo) {
    this.cNo = cNo;
  }

  public int getcQty() {
    return cQty;
  }

  public void setcQty(int cQty) {
    this.cQty = cQty;
  }

  public int getpNo() {
    return pNo;
  }

  public void setpNo(int pNo) {
    this.pNo = pNo;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Cart{cNo=" + cNo +
        ", cQty='" + cQty + '\'' +
        ", pNo=" + pNo +
        '}';
  }

}
