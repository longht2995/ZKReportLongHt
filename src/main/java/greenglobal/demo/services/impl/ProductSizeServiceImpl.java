package greenglobal.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import greenglobal.demo.entity.ProductSize;
import greenglobal.demo.services.ProductSizeService;
@Service("productSizeService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductSizeServiceImpl implements ProductSizeService{
	@Autowired
	private ProductSizeDao productSizeDao;
	public List<ProductSize> listProductSize(Long id) {
		// TODO Auto-generated method stub
		return productSizeDao.listProductSize(id);
	}
	public void saveOrUpdate(ProductSize p) {
		// TODO Auto-generated method stub
		productSizeDao.saveOrUpdate(p);
	}


}
