package greenglobal.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import greenglobal.demo.entity.Product;
import greenglobal.demo.services.ProductService;
@Service("productService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pd;
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		return pd.listAll();
	}
	public List<Product> findByCategory(Long id) {
		// TODO Auto-generated method stub
		return pd.findByCategory(id);
	}
	public void saveorUpdate(Product p) {
		pd.saveOrUpdate(p);
		
	}

}
