package info.thecodinglive.service;

import info.thecodinglive.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryProductService {
    public List<Product> getProductList() {
        Product prod1 = new Product("gray", "t-shirt", 5000);
        Product prod2 = new Product("black", "coffee", 700);
        Product prod3 = new Product("blue", "jam", 2500);
        Product prod4 = new Product("red", "pen", 1500);

        ArrayList<Product> products = new ArrayList();
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);

        return products;
    }
}
