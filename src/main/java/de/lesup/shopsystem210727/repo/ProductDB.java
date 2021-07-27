package de.lesup.shopsystem210727.repo;

import de.lesup.shopsystem210727.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;


@Repository

public class ProductDB {
    private List<Product> productList;

    public ProductDB() {
        Product productVar1 = new Product("0", "Tomate");
        Product productVar2 = new Product("1", "Gurke");

        productList = List.of(productVar1, productVar2);

    }
    public void addProduct(String newProductName){
        String id = UUID.randomUUID().toString();
        Product newProduct = new Product(id, newProductName);
        productList.add(newProduct);

    }

    public List<Product> getListOfProducts() {
        return productList;

    }
}
