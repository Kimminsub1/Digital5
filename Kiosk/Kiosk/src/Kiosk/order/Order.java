package Kiosk.order;

import Kiosk.product.Product;
import java.sql.Date;


public class Order {

  private int oNo;
  private int oPrice;
  private String oDesc;
  private Date oDate;
  private String oPayStatus;

  public Order(int oNo, int oPrice, String oDesc, java.sql.Date oDate, String oPayStatus, Product product) {
  }

  public Order(int oNo, int oPrice, String oDesc, java.sql.Date oDate, String oPayStatus) {
  }

  public Order(int i, String oDesc, Date date, int oTotPrice) {
  }

  public Order(int oTotPrice, String oDesc) {
    this.oPrice = oTotPrice; // 총 가격 초기화
    this.oDesc = oDesc;
  }

  public int getoNo() {
    return oNo;
  }

  public void setoNo(int oNo) {
    this.oNo = oNo;
  }

  public int getoPrice() {
    return oPrice;
  }

  public void setoPrice(int oPrice) {
    this.oPrice = oPrice;
  }

  public String getoDesc() {
    return oDesc;
  }

  public void setoDesc(String oDesc) {
    this.oDesc = oDesc;
  }

  public Date getoDate() {
    return oDate;
  }

  public void setoDate(Date oDate) {
    this.oDate = oDate;
  }

  public String getoPayStatus() {
    return oPayStatus;
  }

  public void setoPayStatus(String oPayStatus) {
    this.oPayStatus = oPayStatus;
  }

  @Override
  public String toString() {
    return "Order{" +
        "oNo=" + oNo +
        ", oPrice=" + oPrice +
        ", oDesc='" + oDesc + '\'' +
        ", oDate=" + oDate +
        ", oPayStatus='" + oPayStatus + '\'' +
        '}';
  }
}