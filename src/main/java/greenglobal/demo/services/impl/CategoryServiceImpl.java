package greenglobal.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import greenglobal.demo.entity.Category;
import greenglobal.demo.services.CategoryService;

@Service("categoryService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao cd;
	public List<Category> listAll() {
		// TODO Auto-generated method stub
		return cd.listCategory();
	}

}
