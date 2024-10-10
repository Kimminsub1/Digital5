package Kiosk.product;

import lombok.ToString;

@ToString
public class Product {

  private int pNo;
  private String pName;
  private String pDesc;
  private String pType;
  private int pPrice;
  private String pColor;
  private String pImg;

  public Product() {
  }

  public Product(int pNo, String pName, String pDesc, String pType, int pPrice, String pColor, String pImg) {
    this.pNo = pNo;
    this.pName = pName;
    this.pDesc = pDesc;
    this.pType = pType;
    this.pPrice = pPrice;
    this.pColor = pColor;
    this.pImg = pImg;
  }

  public Product(int pNo, String pName, int pPrice) {

  }

  // Getter and Setter for pNo
  public int getPNo() {
    return pNo;
  }

  public void setPNo(int pNo) {
    this.pNo = pNo;
  }

  // Getter and Setter for pName
  public String getPName() {
    return pName;
  }

  public void setPName(String pName) {
    this.pName = pName;
  }

  // Getter and Setter for pDesc
  public String getPDesc() {
    return pDesc;
  }

  public void setPDesc(String pDesc) {
    this.pDesc = pDesc;
  }

  // Getter and Setter for pType
  public String getPType() {
    return pType;
  }

  public void setPType(String pType) {
    this.pType = pType;
  }

  // Getter and Setter for pPrice
  public int getPPrice() {
    return pPrice;
  }

  public void setPPrice(int pPrice) {
    this.pPrice = pPrice;
  }

  // Getter and Setter for pColor
  public String getPColor() {
    return pColor;
  }

  public void setPColor(String pColor) {
    this.pColor = pColor;
  }

  // Getter and Setter for pImg
  public String getPImg() {
    return pImg;
  }

  public void setPImg(String pImg) {
    this.pImg = pImg;
  }

  @Override
  public String toString() {
    return "Product{pNo=" + pNo +
        ", pName='" + pName + '\'' +
        ", pDesc=" + pDesc +
        ", pType=" + pType +
        ", pPrice=" + pPrice +
        ", pColor=" + pColor +
        ", pImg='" + pImg + '\'' +
        '}';
  }

}
