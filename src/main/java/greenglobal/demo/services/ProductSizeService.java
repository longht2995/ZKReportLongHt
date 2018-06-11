package greenglobal.demo.services;

import java.util.List;

import greenglobal.demo.entity.ProductSize;

public interface ProductSizeService {
	public List<ProductSize> listProductSize(Long id);
	public void saveOrUpdate(ProductSize p);
}
