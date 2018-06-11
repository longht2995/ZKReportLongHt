package greenglobal.demo.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import greenglobal.demo.entity.Category;
import greenglobal.demo.entity.Product;

@Repository
public class ProductDao {
	@PersistenceContext
	private EntityManager em;
	@Transactional
	public List<Product> listAll(){
		return em.createQuery("SELECT p FROM Product p",Product.class).getResultList();
	}
	public List<Product> findByCategory(Long id){
		return em.createQuery("FROM Product Where category_id = "+id,Product.class).getResultList();
	}
	@Transactional
	public void saveOrUpdate(Product p) {
		em.merge(p);
	}
}
