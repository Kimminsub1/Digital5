package Kiosk.product;

import java.util.List;

public class ProductService {

  private ProductDao productDao;

  public ProductService() throws Exception {
    productDao = new ProductDao();
  }

  public Product productDetail(int pNo) throws Exception {
    return productDao.findByNo(pNo);
  }

  public List<Product> productTypeList(String pType) throws Exception {
    return productDao.findByType(pType);
  }

  public List<Product> productAllList() throws Exception {
    return productDao.findByAll();
  }

}
