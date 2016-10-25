package com.webservice.cxfrest;

import javax.ws.rs.FormParam;
import java.util.List;
import java.util.Map;

/**
 * Created by yjh on 16/10/16.
 */
public class ProductServiceImpl implements ProductService {

    public List<Product> retrieveAllProducts() {
        return null;
    }

    public Product retrieveProductById(long id) {
        return null;
    }

    public List<Product> retrieveProductsByName(@FormParam("name") String name) {
        return null;
    }

    public Product createProduct(Product product) {
        return null;
    }

    public Product updateProductById(long id, Map<String, Object> fieldMap) {
        return null;
    }

    public Product deleteProductById(long id) {
        return null;
    }
}
