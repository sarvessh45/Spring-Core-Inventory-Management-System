package org.inventory.service;
import org.inventory.model.Product;
import java.util.List;

public interface InventoryService {

     void addProduct(Product product);
     List<Product> getAllProducts();
     void updateStock(int id, int quantity);

}
