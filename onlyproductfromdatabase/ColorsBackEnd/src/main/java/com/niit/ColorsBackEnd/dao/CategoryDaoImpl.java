package com.niit.ColorsBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ColorsBackEnd.model.Category;
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public Category category;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listCategory;
	}

	public Category get(String id) {
		String hql = "from Category where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	}
    @Transactional
	public void saveOrUpdate(Category category) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	}

	public void delete(String id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
		
	}

}
