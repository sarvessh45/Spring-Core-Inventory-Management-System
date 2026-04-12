package org.inventory.service;

import org.inventory.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ServiceImplementation implements InventoryService{

    private List<Product> productList = new ArrayList<>();

    @Override
    public void addProduct(Product product)
    {
        productList.add(product);
    }

    @Override
    public List<Product>getAllProducts()
    {
         return productList;
    }

    @Override
    public void updateStock(int id, int quantity) {
        for (Product p : productList) {
            if (p.getId() == id) {
                p.setQuantity(quantity);
            }
        }
    }

}
