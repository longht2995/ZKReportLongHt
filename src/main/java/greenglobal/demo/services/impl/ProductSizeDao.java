package greenglobal.demo.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import greenglobal.demo.entity.ProductSize;

@Repository
public class ProductSizeDao {
	@PersistenceContext
	private EntityManager em;
	public List<ProductSize> listProductSize(Long id){
		return em.createQuery("FROM ProductSize Where product_id ="+id,ProductSize.class).getResultList();
	}
	@Transactional
	public void saveOrUpdate(ProductSize p) {
		em.merge(p);
	}
}
