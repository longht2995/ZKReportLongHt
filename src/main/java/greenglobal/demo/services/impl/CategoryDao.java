package greenglobal.demo.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import greenglobal.demo.entity.Category;

@Repository
public class CategoryDao {
	@PersistenceContext
	private EntityManager em;
	public List<Category> listCategory(){
		return em.createQuery("FROM Category",Category.class).getResultList();
	}
	
}
