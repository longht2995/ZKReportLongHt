package greenglobal.demo;


import greenglobal.demo.entity.Category;
import greenglobal.demo.entity.Product;
import greenglobal.demo.entity.ProductSize;
import greenglobal.demo.services.CategoryService;
import greenglobal.demo.services.ProductService;
import greenglobal.demo.services.ProductSizeService;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {

	@WireVariable
	private ProductService productService;
	@WireVariable
	private CategoryService categoryService;
	@WireVariable
	private ProductSizeService productSizeService;
	private List<Category> listCategory;
	private List<Product> listProduct;
	private Category selectedCategory;
	private Product selectedProduct;
	private List<ProductSize> listProductSize;
	private ProductSize selectProductSize;
	@Init
	public void init() {
		listCategory = new ArrayList<Category>();
		listCategory = categoryService.listAll();
		listProduct = new ArrayList<Product>();
		
		selectedCategory = listCategory.get(0);
		listProduct = productService.findByCategory(selectedCategory.getId());
		selectedProduct = listProduct.get(0);
		listProductSize = productSizeService.listProductSize(selectedProduct.getId());
		if(listProductSize.size()!=0) {
			selectProductSize = listProductSize.get(0);
		}
	}
	@Command
	@NotifyChange({"listProduct","pickedItem","selectedProduct","listProductSize","selectProductSize"})
	public void selected() {
		listProduct = productService.findByCategory(selectedCategory.getId());
		listProductSize = new ArrayList<ProductSize>();
		selectedProduct = listProduct.get(0);
		listProductSize = productSizeService.listProductSize(selectedProduct.getId());
		if(listProductSize.size()!=0) {
			selectProductSize = listProductSize.get(0);
		}
		
		
	}
	@Command
	@NotifyChange({"listProduct","pickedItem","selectedProduct","listProductSize","selectProductSize"})
	public void saveProductSize() {
		productSizeService.saveOrUpdate(selectProductSize);
	}
	@Command
	@NotifyChange({"listProduct","pickedItem","selectedProduct","listProductSize","selectProductSize"})
	public void selectedSize() {
		if((productSizeService.listProductSize(selectedProduct.getId()).size()) !=0) {
			listProductSize = productSizeService.listProductSize(selectedProduct.getId());
			selectProductSize = listProductSize.get(0);
		}
		
	}
	@Command
	@NotifyChange({"listProduct","pickedItem","selectedProduct","listProductSize","selectProductSize"})
	public void addProduct() {
		productService.saveorUpdate(selectedProduct);
	}
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	public Category getSelectedCategory() {
		return selectedCategory;
	}
	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	public List<ProductSize> getListProductSize() {
		return listProductSize;
	}

	public void setListProductSize(List<ProductSize> listProductSize) {
		this.listProductSize = listProductSize;
	}

	public ProductSize getSelectProductSize() {
		return selectProductSize;
	}

	public void setSelectProductSize(ProductSize selectProductSize) {
		this.selectProductSize = selectProductSize;
	}
	
	
	
}
