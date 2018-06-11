package greenglobal.demo.services;

import java.util.List;

import greenglobal.demo.entity.Category;
import greenglobal.demo.entity.Product;

public interface ProductService {
	List<Product> listProduct();
	List<Product> findByCategory(Long id);
	void saveorUpdate(Product p);
}
