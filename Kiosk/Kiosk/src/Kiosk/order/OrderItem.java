package Kiosk.order;

import Kiosk.product.Product;

public class OrderItem {

  private int oiNo;
  private int oNo;
  private int pNo;
  private int oiQty;
  private Product product;

  public OrderItem(int oiNo, int oiQty, int oNo, Product product) {
    this.oiNo = oiNo;
    this.oiQty = oiQty;
    this.oNo = oNo;
    this.product = product;
  }

  public int getOiNo() {
    return oiNo;
  }

  public void setOiNo(int oiNo) {
    this.oiNo = oiNo;
  }

  public int getoNo() {
    return oNo;
  }

  public void setoNo(int oNo) {
    this.oNo = oNo;
  }

  public int getpNo() {
    return pNo;
  }

  public void setpNo(int pNo) {
    this.pNo = pNo;
  }

  public int getOiQty() {
    return oiQty;
  }

  public void setOiQty(int oiQty) {
    this.oiQty = oiQty;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "OrderItem [oiNo=" + oiNo + ", oiQty=" + oiQty + ", oNo=" + oNo + ", product=" + product + "]\n";
  }


}