package com.mayi.dao;

import com.mayi.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private List<Product> productList;

    public List<Product> getProductList(){
        Product product1 = new Product();
        productList = new ArrayList<Product>();
        product1.setProductName("BoostedBoard V2");
        product1.setProductManufacturer("Boosted Board");
        product1.setProductID(556);
        product1.setProductSku("BB102");
        product1.setProductPrice(19.99);
        product1.setProductType("Skateboard");
        product1.setProductDescription("The Revolutionary Boosted Board V2 with a top speed of 22mph and range of 7" +
                " miles!");
        product1.setProductQuantity(12);

        productList.add(product1);

        Product product2 = new Product();
        product2.setProductName("BoostedBoard V1");
        product2.setProductManufacturer("Boosted Board");
        product2.setProductID(555);
        product2.setProductSku("BB101");
        product2.setProductPrice(12.99);
        product2.setProductType("Skateboard");
        product2.setProductDescription("The Revolutionary Boosted Board V2 with a top speed of 22mph and range of 7" +
                " miles!");
        product1.setProductQuantity(12);

        productList.add(product2);

        Product product3 = new Product();
        product3.setProductName("Raptor 2");
        product3.setProductManufacturer("Enertion");
        product3.setProductID(656);
        product3.setProductSku("RP102");
        product3.setProductPrice(21.99);
        product3.setProductType("Skateboard");
        product3.setProductDescription("The Revolutionary Boosted Board V2 with a top speed of 22mph and range of 7" +
                " miles!");
        product1.setProductQuantity(12);

        productList.add(product3);

        return productList;
    }
}
