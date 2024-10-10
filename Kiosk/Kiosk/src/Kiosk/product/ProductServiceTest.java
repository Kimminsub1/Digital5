package Kiosk.product;

class ProductServiceTest {


  public static void main(String[] args) throws Exception {

    ProductService productService = new ProductService();

    System.out.println(productService.productDetail(3));
    System.out.println(productService.productTypeList("Basics"));
    System.out.println(productService.productTypeList("Plus"));
    System.out.println(productService.productTypeList("Ultra"));
    System.out.println(productService.productAllList());

  }
}