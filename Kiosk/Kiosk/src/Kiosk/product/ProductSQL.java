package Kiosk.product;

public class ProductSQL {

  public static final String PRODUCT_SELECT_ALL =
      "SELECT p_no, p_name, p_desc, p_type, p_price, p_color, p_img  FROM Product ORDER BY p_no";
  public static final String PRODUCT_SELECT_NO =
      "SELECT p_no, p_name, p_desc, p_type, p_price, p_color, p_img  FROM Product WHERE p_no=? ORDER BY p_no";
  public static final String PRODUCT_SELECT_TYPE =
      "SELECT p_no, p_name, p_desc, p_type, p_price, p_color, p_img  FROM Product WHERE p_type=? ORDER BY p_no";

}
